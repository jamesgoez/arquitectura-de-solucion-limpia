package co.base.project.model.task.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Optional;

@Data
@Builder(toBuilder = true)
public class TaskInputDomainDTO {

    private Long id;
    private Instant creationDate;
    private Optional<String> nameOfTask;
    private Optional<Integer> dayOfTask;

}
