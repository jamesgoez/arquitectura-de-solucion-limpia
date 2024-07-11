package co.base.project.usecase.task.save;

import co.base.project.usecase.task.gateways.domain.TaskDomainGateway;
import co.base.project.usecase.task.gateways.persistence.ITaskServices;
import co.base.project.usecase.task.save.dto.TaskOutputDTO;
import co.base.project.usecase.task.save.exceptions.InvalidDayOfProofException;
import co.base.project.usecase.task.save.gateways.ISaveTaskUseCase;
import co.base.project.usecase.task.validation.TaskInputDTO;
import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;
import reactor.core.publisher.Mono;

public class SaveTaskUseCase implements ISaveTaskUseCase {

    private final TaskDomainGateway taskDomainGateway;
    private final ITaskServices iTaskServices;

    public SaveTaskUseCase(TaskDomainGateway taskDomainGateway, ITaskServices iTaskServices) {
        this.taskDomainGateway = taskDomainGateway;
        this.iTaskServices = iTaskServices;
    }

    @Override
    public Mono<TaskOutputDTO> execute(Mono<TaskInputDTO> inputUseCaseObject) {
        return inputUseCaseObject
                .map(this::validateDayOfProof)
                .flatMap(iTaskServices::save)
                .flatMap(taskDomainGateway::executeDomainBusinessRules);
    }

    private TaskInputDTO validateDayOfProof(TaskInputDTO taskInputDTO) {
        taskInputDTO.getDayOfTask()
                .filter(dayOfProof -> dayOfProof == 2)
                .ifPresent(day -> { throw new InvalidDayOfProofException(ApplicationCodesEnum.INVALID_DAY_OF_PROOF); });
        return taskInputDTO;
    }
}
