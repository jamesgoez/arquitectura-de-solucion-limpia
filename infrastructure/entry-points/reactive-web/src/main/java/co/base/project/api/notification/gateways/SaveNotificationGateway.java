package co.base.project.api.notification.gateways;

import co.base.project.api.transversal.helpers.ServerRequestToUseCaseInputObjectHelper;
import co.base.project.api.transversal.helpers.ServerResponseHelper;
import co.base.project.usecase.notification.save.dto.SaveNotificationInputDTO;
import co.base.project.usecase.notification.save.dto.SaveNotificationOutputDTO;
import co.base.project.usecase.notification.save.gateways.ISaveNotificationUseCase;
import co.base.project.usecase.transversal.gateways.AbstractUseCaseGateway;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

public class SaveNotificationGateway extends AbstractUseCaseGateway<ServerRequest, SaveNotificationInputDTO, SaveNotificationOutputDTO, ServerResponse> {

    public SaveNotificationGateway(
            ISaveNotificationUseCase iSaveNotificationUseCase,
            ServerResponseHelper<SaveNotificationOutputDTO> serverResponseHelper,
            Validator validator,
            ServerRequestToUseCaseInputObjectHelper<SaveNotificationInputDTO> useCaseInputObjectHelper) {
        super(SaveNotificationInputDTO.class, validator, iSaveNotificationUseCase, serverResponseHelper, useCaseInputObjectHelper);
    }
}
