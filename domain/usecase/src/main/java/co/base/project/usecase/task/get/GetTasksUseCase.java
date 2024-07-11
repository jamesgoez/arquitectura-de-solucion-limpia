package co.base.project.usecase.task.get;

import co.base.project.usecase.task.gateways.persistence.ITaskServices;
import co.base.project.usecase.task.get.dto.GetTasksOutputDTO;
import co.base.project.usecase.task.get.gateways.IGetTasksUseCase;
import reactor.core.publisher.Mono;

public class GetTasksUseCase implements IGetTasksUseCase {

    private final ITaskServices taskServices;

    public GetTasksUseCase(ITaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @Override
    public Mono<GetTasksOutputDTO> execute() {
        return taskServices.getTasks()
                .collectList()
                .map(tasks -> GetTasksOutputDTO.builder()
                        .tasks(tasks)
                        .build());
    }

}
