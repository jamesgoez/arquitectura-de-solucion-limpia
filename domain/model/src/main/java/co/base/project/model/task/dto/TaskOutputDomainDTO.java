package co.base.project.model.task.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder(toBuilder = true)
public class TaskOutputDomainDTO {

    private Long id;
    private String nameOfTask;
    private int dayOfTask;
    private Instant creationDate;
    private Boolean successfulExecution;

}
