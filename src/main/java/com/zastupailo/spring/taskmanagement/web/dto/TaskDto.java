package com.zastupailo.spring.taskmanagement.web.dto;

import com.zastupailo.spring.taskmanagement.persistence.model.Task;
import com.zastupailo.spring.taskmanagement.persistence.model.TaskStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TaskDto {

    private Long id;

    private String name;

    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateCreated;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dueDate;

    private TaskStatus status;

    public TaskDto() {
    }

    public TaskDto(String name, String description, LocalDate dateCreated, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dueDate = dueDate;
    }

    public TaskDto(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.dateCreated = task.getDateCreated();
        this.dueDate = task.getDueDate();
        this.status = task.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
