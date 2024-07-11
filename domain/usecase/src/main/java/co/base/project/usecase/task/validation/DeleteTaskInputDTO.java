package co.base.project.usecase.task.validation;

import co.base.project.usecase.transversal.constants.ErrorsMessagesValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DeleteTaskInputDTO {

    private Long id;

    public Optional<
            @NotNull(message = ErrorsMessagesValidator.ID_NOT_NULL_OR_EMPTY)
            Long> getId() {
        return Optional.ofNullable(id);
    }

}
