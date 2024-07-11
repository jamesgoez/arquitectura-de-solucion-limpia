package co.base.project.usecase.task.get.dto;

import co.base.project.usecase.task.save.dto.TaskOutputDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class GetTasksOutputDTO {
    private List<TaskOutputDTO> tasks;
}
