package co.base.project.usecase.task.delete;

import co.base.project.usecase.task.delete.gateways.IDeleteTaskUseCase;
import co.base.project.usecase.task.gateways.persistence.ITaskServices;
import co.base.project.usecase.task.validation.DeleteTaskInputDTO;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class DeleteTaskUseCase implements IDeleteTaskUseCase {

    private final ITaskServices itaskServices;

    public DeleteTaskUseCase(ITaskServices itaskServices) {
        this.itaskServices = itaskServices;
    }

    @Override
    public Mono<Void> execute(Mono<DeleteTaskInputDTO> inputUseCaseObject) {
        return inputUseCaseObject
                .flatMap(itaskServices::delete);
    }

}
