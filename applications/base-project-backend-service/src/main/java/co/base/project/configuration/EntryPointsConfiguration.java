package co.base.project.configuration;

import co.base.project.api.notification.gateways.GetNotificationGateway;
import co.base.project.api.notification.gateways.SaveNotificationGateway;
import co.base.project.api.tasks.gateways.DeleteTaskGateway;
import co.base.project.api.tasks.gateways.GetTasksGateway;
import co.base.project.api.tasks.gateways.SaveTaskGateway;
import co.base.project.api.transversal.helpers.ServerRequestToUseCaseInputObjectHelper;
import co.base.project.api.transversal.helpers.ServerResponseHelper;
import co.base.project.usecase.notification.get.dto.GetNotificationInputDTO;
import co.base.project.usecase.notification.get.dto.GetNotificationsOutputDTO;
import co.base.project.usecase.notification.get.gateways.IGetNotificationUseCase;
import co.base.project.usecase.notification.save.dto.SaveNotificationInputDTO;
import co.base.project.usecase.notification.save.dto.SaveNotificationOutputDTO;
import co.base.project.usecase.notification.save.gateways.ISaveNotificationUseCase;
import co.base.project.usecase.task.delete.DeleteTaskUseCase;
import co.base.project.usecase.task.get.dto.GetTasksOutputDTO;
import co.base.project.usecase.task.get.gateways.IGetTasksUseCase;
import co.base.project.usecase.task.save.dto.TaskOutputDTO;
import co.base.project.usecase.task.save.gateways.ISaveTaskUseCase;
import co.base.project.usecase.task.validation.DeleteTaskInputDTO;
import co.base.project.usecase.task.validation.TaskInputDTO;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;

@Configuration
public class EntryPointsConfiguration {

    @Bean
    public WebFluxProperties buildWebFluxProperties() {
        return new WebFluxProperties();
    }

    @Bean
    public SaveNotificationGateway buildSaveNotificationGateway(
            ISaveNotificationUseCase useCase,
            ServerResponseHelper<SaveNotificationOutputDTO> serverResponseHelper,
            Validator validator,
            ServerRequestToUseCaseInputObjectHelper<SaveNotificationInputDTO> serverRequestToUseCaseInputObjectHelper) {
        return new SaveNotificationGateway(
                useCase, serverResponseHelper, validator, serverRequestToUseCaseInputObjectHelper);
    }

    @Bean
    public ServerResponseHelper<SaveNotificationOutputDTO> buildServerResponseHelperSaveNotificationUseCase() {
        return new ServerResponseHelper<>();
    }

    @Bean
    public ServerRequestToUseCaseInputObjectHelper<SaveNotificationInputDTO> buildServerRequestToUseCaseInputObjectHelperSaveNotificationUseCase() {
        return new ServerRequestToUseCaseInputObjectHelper<>(SaveNotificationInputDTO.class);
    }

    @Bean
    public GetNotificationGateway buildGetNotificationGateway(
            Validator validator,
            IGetNotificationUseCase iGetNotificationUseCase,
            ServerResponseHelper<GetNotificationsOutputDTO> responseHelper,
            ServerRequestToUseCaseInputObjectHelper<GetNotificationInputDTO> useCaseInputObjectHelper
    ) {
        return new GetNotificationGateway(validator, iGetNotificationUseCase, responseHelper, useCaseInputObjectHelper);
    }

    @Bean
    public ServerRequestToUseCaseInputObjectHelper<GetNotificationInputDTO> buildServerRequestGetNotificationGateway() {
        return new ServerRequestToUseCaseInputObjectHelper<>(GetNotificationInputDTO.class);
    }

    @Bean
    public ServerResponseHelper<GetNotificationsOutputDTO> buildResponseHelperGetBoardListGateway() {
        return new ServerResponseHelper<>();
    }

    @Bean
    public SaveTaskGateway buildSaveTaskGateway(
            ISaveTaskUseCase useCase,
            ServerResponseHelper<TaskOutputDTO> serverResponseHelper,
            Validator validator,
            ServerRequestToUseCaseInputObjectHelper<TaskInputDTO> serverRequestToUseCaseInputObjectHelper) {
        return new SaveTaskGateway(
                useCase, serverResponseHelper, validator, serverRequestToUseCaseInputObjectHelper);
    }

    @Bean
    public ServerResponseHelper<TaskOutputDTO> buildServerResponseHelperSaveTaskUseCase() {
        return new ServerResponseHelper<>();
    }

    @Bean
    public GetTasksGateway buildGetTasksGateway(
            IGetTasksUseCase iUseCase,
            ServerResponseHelper<GetTasksOutputDTO> serverResponseHelper) {
        return new GetTasksGateway(iUseCase, serverResponseHelper);
    }

    @Bean
    public ServerResponseHelper<GetTasksOutputDTO> buildResponseHelperGetTasksUseCase() {
        return new ServerResponseHelper<>();
    }

    @Bean
    public DeleteTaskGateway buildDeleteTaskGateway(
            Validator validator,
            DeleteTaskUseCase deleteTaskUseCase,
            ServerResponseHelper<Void> voidServerResponseHelper,
            ServerRequestToUseCaseInputObjectHelper<DeleteTaskInputDTO> useCaseInputObjectHelper
    ) {
        return new DeleteTaskGateway(validator, deleteTaskUseCase, voidServerResponseHelper, useCaseInputObjectHelper);
    }

    @Bean
    public ServerRequestToUseCaseInputObjectHelper<TaskInputDTO> buildServerRequestToUseCaseInputObjectHelper() {
        return new ServerRequestToUseCaseInputObjectHelper<>(TaskInputDTO.class);
    }

    @Bean
    public ServerResponseHelper<Void> buildServerResponseHelperOfDeleteTaskUseCase() {
        return new ServerResponseHelper<>();
    }

    @Bean
    public ServerRequestToUseCaseInputObjectHelper<DeleteTaskInputDTO> buildServerRequestToUseCaseInputObjectHelperDeleteTaskUseCase() {
        return new ServerRequestToUseCaseInputObjectHelper<>(DeleteTaskInputDTO.class);
    }

}
