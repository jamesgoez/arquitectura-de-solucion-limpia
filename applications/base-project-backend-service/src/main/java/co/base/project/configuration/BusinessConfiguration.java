package co.base.project.configuration;

import co.base.project.business.notification.NotificationBusiness;
import co.base.project.business.task.TaskBusiness;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfiguration {

    @Bean
    public NotificationBusiness buildNotificationBusiness() {
        return new NotificationBusiness();
    }

    @Bean
    public TaskBusiness buildPruebaBusinessGateway() {
        return new TaskBusiness();
    }

}
