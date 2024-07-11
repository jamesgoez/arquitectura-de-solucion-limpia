package co.base.project.usecase.notification.save;

import co.base.project.usecase.mail.services.MailService;
import co.base.project.usecase.notification.gateways.domain.NotificationDomainGateway;
import co.base.project.usecase.notification.gateways.persistence.INotificationServices;
import co.base.project.usecase.notification.save.dto.SaveNotificationInputDTO;
import co.base.project.usecase.notification.save.dto.SaveNotificationOutputDTO;
import co.base.project.usecase.notification.save.gateways.ISaveNotificationUseCase;
import co.base.project.usecase.weather.api.dto.WeatherInputDTO;
import co.base.project.usecase.weather.api.gateways.IWeatherAPIConsumerService;
import reactor.core.publisher.Mono;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveNotificationUseCase implements ISaveNotificationUseCase {

    private final List<Integer> forecastCodeList = new ArrayList(Arrays.asList(1186, 1189, 1192, 1195));

    private final NotificationDomainGateway notificationDomainGateway;
    private final INotificationServices iNotificationServices;
    private final IWeatherAPIConsumerService iWeatherAPIConsumerService;
    private final MailService mailService;


    public SaveNotificationUseCase(NotificationDomainGateway notificationDomainGateway, INotificationServices iNotificationServices, IWeatherAPIConsumerService iWeatherAPIConsumerService, MailService mailService) {
        this.notificationDomainGateway = notificationDomainGateway;
        this.iNotificationServices = iNotificationServices;
        this.iWeatherAPIConsumerService = iWeatherAPIConsumerService;
        this.mailService = mailService;
    }

    @Override
    public Mono<SaveNotificationOutputDTO> execute(Mono<SaveNotificationInputDTO> notificationInputDTOMono) {
        return notificationInputDTOMono.map(notificationInputDTO ->
                        iWeatherAPIConsumerService.getWeather(WeatherInputDTO.builder()
                                .latitude(notificationInputDTO.getLatitude().orElseThrow())
                                .longitude(notificationInputDTO.getLongitude().orElseThrow())
                                .build()).map(weatherOutputDTO ->
                                notificationInputDTO.toBuilder()
                                        .forecastCode(weatherOutputDTO.getForecastCode())
                                        .forecastDescription(weatherOutputDTO.getForecastDescription())
                                        .build()))
                .flatMap(this::validateForecastCode)
                .flatMap(iNotificationServices::save)
                .flatMap(notificationDomainGateway::executeDomainBusinessRules);

    }

    private Mono<SaveNotificationInputDTO> validateForecastCode(Mono<SaveNotificationInputDTO> notificationInputDTO) {

        return notificationInputDTO.map(notificationInput -> notificationInput.toBuilder().buyerNotification(forecastCodeList.stream()
                        .anyMatch(s -> s.equals(notificationInput.getForecastCode()))).build())
                .flatMap(saveNotificationInputDTO -> Mono.just(saveNotificationInputDTO)
                        .filter(saveNotificationInputFilter -> saveNotificationInputFilter.getBuyerNotification()).thenReturn(saveNotificationInputDTO)
                        .map(saveNotificationInputTrue -> {
                            try {
                                mailService.sendHtmlEmail(saveNotificationInputDTO);
                            } catch (MessagingException e) {
                                e.printStackTrace();
                            }
                            return saveNotificationInputDTO.toBuilder().build();
                        }));
    }

}
