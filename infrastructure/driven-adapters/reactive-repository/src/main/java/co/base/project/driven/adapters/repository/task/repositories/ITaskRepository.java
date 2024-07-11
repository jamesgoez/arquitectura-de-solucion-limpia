package co.base.project.driven.adapters.repository.task.repositories;

import co.base.project.driven.adapters.repository.task.entities.TaskEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ITaskRepository extends ReactiveCrudRepository<TaskEntity, Long> {
    Flux<TaskEntity> findAllByOrderByIdDesc();
}
