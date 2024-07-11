package co.base.project.driven.adapters.repository.task.mappers;

import co.base.project.driven.adapters.repository.task.entities.TaskEntity;
import co.base.project.usecase.task.save.dto.TaskOutputDTO;
import co.base.project.usecase.task.validation.TaskInputDTO;

public interface ITaskEntityMapper {

    TaskEntity toTaskEntity(TaskInputDTO taskInputDTO);
    TaskOutputDTO toTaskOutputDTO(TaskEntity taskEntity);

}
