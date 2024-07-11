package co.base.project.driven.adapters.repository.task.mappers.impl;

import co.base.project.driven.adapters.repository.task.entities.TaskEntity;
import co.base.project.driven.adapters.repository.task.mappers.ITaskEntityMapper;
import co.base.project.usecase.task.save.dto.TaskOutputDTO;
import co.base.project.usecase.task.validation.TaskInputDTO;

import java.time.Instant;

public class TaskEntityMapper implements ITaskEntityMapper {

    @Override
    public TaskEntity toTaskEntity(TaskInputDTO taskInputDTO) {
        return TaskEntity.builder()
                .nameOfTask(taskInputDTO.getNameOfTask().orElse(""))
                .dayOfTask(taskInputDTO.getDayOfTask().orElse(1))
                .creationDate(Instant.now())
                .build();
    }

    @Override
    public TaskOutputDTO toTaskOutputDTO(TaskEntity taskEntity) {
        return TaskOutputDTO.builder()
                .id(taskEntity.getId())
                .dayOfTask(taskEntity.getDayOfTask())
                .nameOfTask(taskEntity.getNameOfTask())
                .creationDate(taskEntity.getCreationDate())
                .build();
    }

}
