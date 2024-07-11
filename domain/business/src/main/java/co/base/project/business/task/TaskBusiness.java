package co.base.project.business.task;

import co.base.project.model.task.dto.TaskInputDomainDTO;
import co.base.project.model.task.dto.TaskOutputDomainDTO;
import co.base.project.model.task.gateways.ITaskBusinessGateway;
import reactor.core.publisher.Mono;

public class TaskBusiness implements ITaskBusinessGateway {

    @Override
    public Mono<TaskOutputDomainDTO> executeBusinessRules(TaskInputDomainDTO taskInputDomainDTO) {
        return Mono.just(TaskOutputDomainDTO.builder()
                .id(taskInputDomainDTO.getId())
                .dayOfTask(taskInputDomainDTO.getDayOfTask().orElse(32))
                .nameOfTask(taskInputDomainDTO.getNameOfTask().orElse("NOT FOUND"))
                .creationDate(taskInputDomainDTO.getCreationDate())
                .successfulExecution(true)
                .build());
    }

}
