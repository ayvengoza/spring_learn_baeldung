package com.zastupailo.spring.taskmanagement.repository.impl;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import com.zastupailo.spring.taskmanagement.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Profile(value = "dev")
@Repository
public class ProjectRepositoryImpl implements IProjectRepository {
    List<Project> projects = new ArrayList<>();

    @Value("${project.prefix}")
    private String prefix;

    @Value("${project.sufix}")
    private Integer sufix;

    @PostConstruct
    public void init() {
        System.out.println("INIT " + this.getClass());
        System.out.println("VALUE " + prefix + " " + sufix);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("DESTROY " + this.getClass());
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(project -> project.getId().equals(id)).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        if (existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }
        return project;
    }
}
