package com.zastupailo.spring.taskmanagement.persistence.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate dateCreated;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Set<Task> tasks;

    public Project() {

    }
    public Project(String name, LocalDate dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public Project(Project project) {
        this(project.getName(), project.getDateCreated());
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id.equals(project.id) &&
                name.equals(project.name) &&
                dateCreated.equals(project.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateCreated);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
