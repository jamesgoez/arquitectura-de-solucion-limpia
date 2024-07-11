package co.base.project.api.tasks.handler;

import co.base.project.api.tasks.gateways.DeleteTaskGateway;
import co.base.project.api.tasks.gateways.GetTasksGateway;
import co.base.project.api.tasks.gateways.SaveTaskGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskHandler {

    private final SaveTaskGateway saveTaskGateway;
    private final GetTasksGateway getTasksGateway;
    private final DeleteTaskGateway deleteTaskGateway;

    public Mono<ServerResponse> saveTask(ServerRequest serverRequest) {
        return saveTaskGateway.execute(serverRequest);
    }

    public Mono<ServerResponse> getTasks() {
        return getTasksGateway.execute();
    }

    public Mono<ServerResponse> deleteTask(ServerRequest serverRequest) {
        return deleteTaskGateway.execute(serverRequest);
    }
}
