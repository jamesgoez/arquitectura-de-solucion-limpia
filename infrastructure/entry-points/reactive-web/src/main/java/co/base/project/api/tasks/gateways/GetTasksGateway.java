package co.base.project.api.tasks.gateways;

import co.base.project.usecase.task.get.dto.GetTasksOutputDTO;
import co.base.project.usecase.transversal.gateways.AbstractWithoutInputUseCaseGateway;
import co.base.project.usecase.transversal.gateways.IResponseHelper;
import co.base.project.usecase.transversal.gateways.IWithoutInputUseCase;
import org.springframework.web.reactive.function.server.ServerResponse;

public class GetTasksGateway extends AbstractWithoutInputUseCaseGateway<GetTasksOutputDTO, ServerResponse> {

    public GetTasksGateway(
            IWithoutInputUseCase<GetTasksOutputDTO> iUseCase,
            IResponseHelper<GetTasksOutputDTO, ServerResponse> responseHelper) {
        super(iUseCase, responseHelper);
    }

}
