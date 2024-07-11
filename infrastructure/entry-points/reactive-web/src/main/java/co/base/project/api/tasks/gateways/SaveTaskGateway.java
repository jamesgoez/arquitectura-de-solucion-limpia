package co.base.project.api.tasks.gateways;

import co.base.project.api.transversal.helpers.ServerRequestToUseCaseInputObjectHelper;
import co.base.project.api.transversal.helpers.ServerResponseHelper;
import co.base.project.usecase.task.save.dto.TaskOutputDTO;
import co.base.project.usecase.task.save.gateways.ISaveTaskUseCase;
import co.base.project.usecase.task.validation.TaskInputDTO;
import co.base.project.usecase.transversal.gateways.AbstractUseCaseGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

@Slf4j
public class SaveTaskGateway extends AbstractUseCaseGateway<ServerRequest, TaskInputDTO, TaskOutputDTO, ServerResponse> {

    public SaveTaskGateway(
            ISaveTaskUseCase saveTaskUseCase,
            ServerResponseHelper<TaskOutputDTO> serverResponseHelper,
            Validator validator,
            ServerRequestToUseCaseInputObjectHelper<TaskInputDTO> useCaseInputObjectHelper) {
        super(TaskInputDTO.class, validator, saveTaskUseCase, serverResponseHelper, useCaseInputObjectHelper);
    }

}
