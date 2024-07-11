package co.base.project.driven.adapters.repository.notification.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@NoArgsConstructor
@Table(value = "notification")
public class NotificationEntity {

    @Builder(toBuilder = true)
    public NotificationEntity(Long id, String buyerEmail, double latitude, double longitude, Integer forecastCode, String forecastDescription, Boolean buyerNotification, Instant creationDate) {
        this.id = id;
        this.buyerEmail = buyerEmail;
        this.latitude = latitude;
        this.longitude = longitude;
        this.forecastCode = forecastCode;
        this.forecastDescription = forecastDescription;
        this.buyerNotification = buyerNotification;
        this.creationDate = creationDate;
    }

    @Id
    @Column(value = "id")
    @Getter
    private Long id;

    @Column(value = "buyer_email")
    @Getter
    @Setter
    private String buyerEmail;

    @Getter
    @Setter
    private double latitude;

    @Getter
    @Setter
    private double longitude;

    @Column(value = "forecast_code")
    @Getter
    @Setter
    private Integer forecastCode;

    @Column(value = "forecast_description")
    @Getter
    @Setter
    private String forecastDescription;

    @Column(value = "buyer_notification")
    @Getter
    @Setter
    private Boolean buyerNotification;

    @Column(value = "creation_date")
    @Getter
    @Setter
    private Instant creationDate;

}
