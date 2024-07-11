package co.base.project.usecase.task.save.gateways;

import co.base.project.usecase.task.save.dto.TaskOutputDTO;
import co.base.project.usecase.task.validation.TaskInputDTO;
import co.base.project.usecase.transversal.gateways.IUseCase;

public interface ISaveTaskUseCase extends IUseCase<TaskInputDTO, TaskOutputDTO> {
}
