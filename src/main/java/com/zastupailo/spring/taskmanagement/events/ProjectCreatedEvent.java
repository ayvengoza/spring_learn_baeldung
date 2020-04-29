package com.zastupailo.spring.taskmanagement.events;

public class ProjectCreatedEvent {

    private Long projectId;

    public ProjectCreatedEvent(Long projectId) {
        super();
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
