package co.base.project.api.configuration.router;

import co.base.project.api.configuration.router.enums.RouterEnum;
import co.base.project.api.notification.handler.NotificationHandler;
import co.base.project.api.tasks.handler.TaskHandler;
import co.base.project.usecase.notification.get.dto.GetNotificationsOutputDTO;
import co.base.project.usecase.notification.save.dto.SaveNotificationInputDTO;
import co.base.project.usecase.notification.save.dto.SaveNotificationOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.models.media.StringSchema;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Map;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
@RequiredArgsConstructor
public class Router {

    private final TaskHandler taskHandler;
    private final NotificationHandler notificationHandler;

    @Bean
    @RouterOperations({
            @RouterOperation(path = "/buyer/notification", produces = {

                    MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = NotificationHandler.class, beanMethod = "saveNotification",
                    operation = @Operation(description = "Guarda el registro de notificaciones enviadas al correo de un buyer", operationId = "saveNotification",
                            requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = SaveNotificationInputDTO.class)))
                            ,
                            responses = {
                                    @ApiResponse(responseCode = "200", description = "successful operation", content = {@Content(mediaType = "application/json",
                                            schema = @Schema(implementation = SaveNotificationOutputDTO.class))}),
                                    @ApiResponse(responseCode = "400", description = "El campo buyerEmail es obligatorio", content = @Content),
                                    @ApiResponse(responseCode = "2-400", description = "Debes enviar un cuerpo de solicitud para el consumo de este servicio", content = @Content)}
                    )),
            @RouterOperation(path = "/buyer/notification", produces = {
                    MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET, beanClass = NotificationHandler.class, beanMethod = "getNotifications",
                    operation =
                    @Operation(description = "Consulta las notificaciones enviadas a un Buyer", operationId = "getNotifications",

                            parameters = {@Parameter(name = "buyerEmail", description = "Email del Buyer", example = "jamesgoez@hotmail.com", in = ParameterIn.QUERY, schema = @Schema(type = "String"))
                            },
                            responses = {
                                    @ApiResponse(responseCode = "200", description = "successful operation", content = {@Content(mediaType = "application/json",
                                            schema = @Schema(implementation = GetNotificationsOutputDTO.class))}),
                                    @ApiResponse(responseCode = "2-400", description = "El campo Buyer Email es obligatorio", content = @Content),
                                    @ApiResponse(responseCode = "3-400", description = "Datos de entrada no v\u00e1lidos", content = @Content)
                            }
                    ))
    })

    public RouterFunction<ServerResponse> composedRoutes() {
        return route(POST(RouterEnum.NOTIFICATION.getRoute()).and(accept(MediaType.APPLICATION_JSON)), notificationHandler::saveNotification)
                .andRoute(GET(RouterEnum.NOTIFICATION.getRoute()).and(accept(MediaType.APPLICATION_JSON)), notificationHandler::getNotifications)
                .andRoute(GET(RouterEnum.TASK.getRoute()), request -> taskHandler.getTasks())
                .andRoute(DELETE(RouterEnum.TASK.getRoute()).and(accept(MediaType.APPLICATION_JSON)), taskHandler::deleteTask);
    }

}
