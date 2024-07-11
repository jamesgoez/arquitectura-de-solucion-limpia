package co.base.project.usecase.task.gateways.persistence;

import co.base.project.usecase.task.save.dto.TaskOutputDTO;
import co.base.project.usecase.task.validation.DeleteTaskInputDTO;
import co.base.project.usecase.task.validation.TaskInputDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITaskServices {

    Mono<TaskOutputDTO> save(TaskInputDTO taskInputDTO);
    Flux<TaskOutputDTO> getTasks();
    Mono<Void> delete(DeleteTaskInputDTO taskInputDTO);

}
