package co.base.project.driven.adapters.repository.task.entities;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@NoArgsConstructor

@Table(value = "task")
public class TaskEntity {

    @Builder(toBuilder = true)
    public TaskEntity(Integer dayOfTask, String nameOfTask, Instant creationDate) {
        this.dayOfTask = dayOfTask;
        this.nameOfTask = nameOfTask;
        this.creationDate = creationDate;
    }

    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "day_of_task")
    private Integer dayOfTask;

    @Column(value = "name_of_task")
    private String nameOfTask;

    @Column(value = "creation_date")
    private Instant creationDate;

    public Integer getDayOfTask() {
        return dayOfTask;
    }

    public void setDayOfTask(Integer dayOfTask) {
        this.dayOfTask = dayOfTask;
    }

    public String getNameOfTask() {
        return nameOfTask;
    }

    public void setNameOfTask(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }
}
