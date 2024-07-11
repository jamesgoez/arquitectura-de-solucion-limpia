package co.base.project.usecase.notification.get.dto;

import co.base.project.usecase.transversal.constants.ErrorsMessagesValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class GetNotificationInputDTO {

    private String buyerEmail;

    public Optional<@NotEmpty(message = ErrorsMessagesValidator.BUYER_EMAIL_IS_NOT_NULL) String> getBuyerEmail() {
        return Optional.ofNullable(buyerEmail);
    }
}
