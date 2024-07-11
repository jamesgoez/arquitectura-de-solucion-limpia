package co.base.project.configuration;

import co.base.project.model.notification.gateways.INotificationBusinessGateway;
import co.base.project.model.task.gateways.ITaskBusinessGateway;
import co.base.project.usecase.mail.services.MailService;
import co.base.project.usecase.notification.gateways.domain.NotificationDomainGateway;
import co.base.project.usecase.notification.gateways.persistence.INotificationServices;
import co.base.project.usecase.notification.get.GetNotificationUseCase;
import co.base.project.usecase.notification.save.SaveNotificationUseCase;
import co.base.project.usecase.task.delete.DeleteTaskUseCase;
import co.base.project.usecase.task.gateways.domain.TaskDomainGateway;
import co.base.project.usecase.task.gateways.persistence.ITaskServices;
import co.base.project.usecase.task.get.GetTasksUseCase;
import co.base.project.usecase.task.save.SaveTaskUseCase;
import co.base.project.usecase.weather.api.gateways.IWeatherAPIConsumerService;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@Configuration
public class UseCaseConfiguration {

    @Bean
    @Primary
    public LocalValidatorFactoryBean buildValidator() {
        val localValidatorFactoryBean = new LocalValidatorFactoryBean();
        return localValidatorFactoryBean;
    }

    @Bean
    public SaveNotificationUseCase buildSaveNotificationUseCase(
            NotificationDomainGateway notificationDomainGateway, INotificationServices iNotificationServices, IWeatherAPIConsumerService iWeatherAPIConsumerService, MailService sendHtmlEmail) {
        return new SaveNotificationUseCase(notificationDomainGateway, iNotificationServices, iWeatherAPIConsumerService, sendHtmlEmail);
    }

    @Bean
    public NotificationDomainGateway buildNotificationDomainGateway(INotificationBusinessGateway iNotificationBusinessGateway) {
        return new NotificationDomainGateway(iNotificationBusinessGateway);
    }

    @Bean
    public GetNotificationUseCase buildGetNotificationUseCase(INotificationServices iNotificationServices) {
        return new GetNotificationUseCase(iNotificationServices);
    }

    @Bean
    public MailService buildMailService() {
        return new MailService();
    }

    @Bean
    public SaveTaskUseCase buildSaveTaskUseCase(
            TaskDomainGateway taskDomainGateway, ITaskServices iTaskServices) {
        return new SaveTaskUseCase(taskDomainGateway, iTaskServices);
    }


    @Bean
    public TaskDomainGateway buildTaskDomainGateway(ITaskBusinessGateway pruebaBusiness) {
        return new TaskDomainGateway(pruebaBusiness);
    }

    @Bean
    public GetTasksUseCase buildGetTasksUseCase(ITaskServices taskServices) {
        return new GetTasksUseCase(taskServices);
    }

    @Bean
    public DeleteTaskUseCase buildDeleteTaskUseCase(ITaskServices itaskServices) {
        return new DeleteTaskUseCase(itaskServices);
    }
}

