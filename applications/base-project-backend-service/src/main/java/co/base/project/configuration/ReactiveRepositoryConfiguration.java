package co.base.project.configuration;

import co.base.project.driven.adapters.repository.notification.mappers.impl.GetNotificationEntityMapper;
import co.base.project.driven.adapters.repository.notification.mappers.impl.NotificationEntityMapper;
import co.base.project.driven.adapters.repository.task.mappers.impl.TaskEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReactiveRepositoryConfiguration {

    @Bean
    public NotificationEntityMapper buildNotificationEntityMapper() {
        return new NotificationEntityMapper();
    }

    @Bean
    public GetNotificationEntityMapper buildGetNotificationEntityMapper() {
        return new GetNotificationEntityMapper();
    }

    @Bean
    public TaskEntityMapper buildTaskEntityMapper() {
        return new TaskEntityMapper();
    }

}
