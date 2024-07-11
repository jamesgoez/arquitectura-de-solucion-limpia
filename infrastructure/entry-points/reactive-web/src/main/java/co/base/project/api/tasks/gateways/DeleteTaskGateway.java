package co.base.project.api.tasks.gateways;

import co.base.project.api.transversal.helpers.ServerRequestToUseCaseInputObjectHelper;
import co.base.project.api.transversal.helpers.ServerResponseHelper;
import co.base.project.usecase.task.delete.DeleteTaskUseCase;
import co.base.project.usecase.task.validation.DeleteTaskInputDTO;
import co.base.project.usecase.transversal.gateways.AbstractUseCaseGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

@Slf4j
public class DeleteTaskGateway extends AbstractUseCaseGateway<ServerRequest, DeleteTaskInputDTO, Void, ServerResponse> {

    public DeleteTaskGateway(
            Validator validator,
            DeleteTaskUseCase iUseCase,
            ServerResponseHelper<Void> responseHelper,
            ServerRequestToUseCaseInputObjectHelper<DeleteTaskInputDTO> useCaseInputObjectHelper
            ) {
        super(DeleteTaskInputDTO.class, validator, iUseCase, responseHelper, useCaseInputObjectHelper);
    }

}
