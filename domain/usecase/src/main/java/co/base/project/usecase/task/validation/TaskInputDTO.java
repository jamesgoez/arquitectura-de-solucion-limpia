package co.base.project.usecase.task.validation;

import co.base.project.usecase.transversal.constants.ErrorsMessagesValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TaskInputDTO {

    private String nameOfTask;
    private Integer dayOfTask;

    public Optional<
            @NotEmpty(message = ErrorsMessagesValidator.NAME_OF_TASK_NOT_NULL_OR_EMPTY)
                    String> getNameOfTask() {
        return Optional.ofNullable(nameOfTask);
    }

    public Optional<
            @NotNull(message = ErrorsMessagesValidator.DAY_OF_TASK_NOT_NULL)
            @Positive(message = ErrorsMessagesValidator.DAY_OF_TASK_MUST_BE_POSITIVE)
                    Integer> getDayOfTask() {
        return Optional.ofNullable(dayOfTask);
    }

}
