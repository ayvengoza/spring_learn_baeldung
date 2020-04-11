package com.zastupailo.spring.taskmanagement.web.dto;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectDto {

    private Long id;
    private String name;

    private Set<TaskDto> tasksDtos;


    public ProjectDto(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.tasksDtos = project.getTasks().stream().map(task -> new TaskDto(task)).collect(Collectors.toSet());
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

    public Set<TaskDto> getTasksDto() {
        return tasksDtos;
    }

    public void setTasksDtos(Set<TaskDto> tasksDtos) {
        this.tasksDtos = tasksDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDto project = (ProjectDto) o;
        return id.equals(project.id) &&
                name.equals(project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
