package co.base.project.usecase.notification.save.dto;

import co.base.project.usecase.transversal.constants.ErrorsMessagesValidator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SaveNotificationInputDTO {

    private String buyerEmail;
    private double latitude;
    private double longitude;
    @Getter
    @JsonIgnore
    private Integer forecastCode;
    @Getter
    @JsonIgnore
    private String forecastDescription;
    @Getter
    @JsonIgnore
    private Boolean buyerNotification;

    public Optional<@NotEmpty(message = ErrorsMessagesValidator.BUYER_EMAIL_IS_NOT_NULL) String> getBuyerEmail() {
        return Optional.ofNullable(buyerEmail);
    }

    public Optional<@NotNull(message = ErrorsMessagesValidator.LATITUDE_IS_NOT_NULL) Double> getLatitude() {
        return Optional.ofNullable(latitude);
    }

    public Optional<@NotNull(message = ErrorsMessagesValidator.LONGITUDE_IS_NOT_NULL) Double> getLongitude() {
        return Optional.ofNullable(longitude);
    }
}
