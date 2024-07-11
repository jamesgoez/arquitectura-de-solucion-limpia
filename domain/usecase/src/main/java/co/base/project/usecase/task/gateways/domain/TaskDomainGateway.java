package co.base.project.usecase.task.gateways.domain;

import co.base.project.model.task.dto.TaskInputDomainDTO;
import co.base.project.model.task.dto.TaskOutputDomainDTO;
import co.base.project.model.task.gateways.ITaskBusinessGateway;
import co.base.project.model.transversal.gateways.AbstractDomainGateway;
import co.base.project.usecase.task.save.dto.TaskOutputDTO;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class TaskDomainGateway extends AbstractDomainGateway<TaskOutputDTO, TaskInputDomainDTO, TaskOutputDomainDTO, TaskOutputDTO> {

    private final ITaskBusinessGateway taskBusinessGateway;

    public TaskDomainGateway(ITaskBusinessGateway taskBusinessGateway) {
        this.taskBusinessGateway = taskBusinessGateway;
    }

    @Override
    protected TaskInputDomainDTO buildDomainInputObject(TaskOutputDTO inputObject) {
        return TaskInputDomainDTO.builder()
                .id(inputObject.getId())
                .dayOfTask(Optional.ofNullable(inputObject.getDayOfTask()))
                .nameOfTask(Optional.ofNullable(inputObject.getNameOfTask()))
                .creationDate(inputObject.getCreationDate())
                .build();
    }

    @Override
    protected Mono<TaskOutputDomainDTO> executeBusinessRules(TaskInputDomainDTO domainInputObject) {
        return taskBusinessGateway.executeBusinessRules(domainInputObject);
    }

    @Override
    protected Mono<TaskOutputDTO> buildOutputObject(Mono<TaskOutputDomainDTO> domainOutputObject) {
        return domainOutputObject
                .map(taskOutputDomainDTO -> TaskOutputDTO.builder()
                        .id(taskOutputDomainDTO.getId())
                        .dayOfTask(taskOutputDomainDTO.getDayOfTask())
                        .nameOfTask(taskOutputDomainDTO.getNameOfTask())
                        .creationDate(taskOutputDomainDTO.getCreationDate())
                        .successfulExecution(taskOutputDomainDTO.getSuccessfulExecution())
                        .build());
    }

}
