package co.base.project.usecase.task.save.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder(toBuilder = true)
public class TaskOutputDTO {

    private Long id;
    private String nameOfTask;
    private int dayOfTask;
    private Instant creationDate;
    private Boolean successfulExecution;

}
