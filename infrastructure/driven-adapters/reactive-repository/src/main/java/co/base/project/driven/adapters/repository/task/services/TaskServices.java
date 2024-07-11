package co.base.project.driven.adapters.repository.task.services;

import co.base.project.driven.adapters.repository.task.exceptions.TaskNotFoundException;
import co.base.project.driven.adapters.repository.task.mappers.ITaskEntityMapper;
import co.base.project.driven.adapters.repository.task.repositories.ITaskRepository;
import co.base.project.usecase.task.gateways.persistence.ITaskServices;
import co.base.project.usecase.task.save.dto.TaskOutputDTO;
import co.base.project.usecase.task.validation.DeleteTaskInputDTO;
import co.base.project.usecase.task.validation.TaskInputDTO;
import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
public class TaskServices implements ITaskServices {

    private final ITaskRepository iTaskRepository;
    private final ITaskEntityMapper iTaskEntityMapper;

    public TaskServices(
            ITaskRepository iTaskRepository,
            ITaskEntityMapper cleanArchitectureTestEntityMapper) {
        this.iTaskRepository = iTaskRepository;
        this.iTaskEntityMapper = cleanArchitectureTestEntityMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Mono<TaskOutputDTO> save(TaskInputDTO taskInputDTO) {
        val cleanArchitectureTestEntity =
                iTaskEntityMapper.toTaskEntity(taskInputDTO);
        log.info("Creation Date -> ".concat(cleanArchitectureTestEntity.getCreationDate().toString()));
        return iTaskRepository.save(cleanArchitectureTestEntity)
                .map(iTaskEntityMapper::toTaskOutputDTO);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Flux<TaskOutputDTO> getTasks() {
        return iTaskRepository.findAllByOrderByIdDesc()
                .map(iTaskEntityMapper::toTaskOutputDTO);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Mono<Void> delete(DeleteTaskInputDTO deleteTaskInputDTO) {
        return deleteTaskInputDTO.getId()
                .map(id ->
                        iTaskRepository.findById(id)
                                .switchIfEmpty(Mono.error(new TaskNotFoundException(ApplicationCodesEnum.NO_PUDIMOS_BORRAR_LA_TAREA_PORQUE_NO_FUE_ENCONTRADA)))
                                .flatMap(iTaskRepository::delete)
                ).orElse(Mono.empty());
    }

}
