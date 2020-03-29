package com.zastupailo.spring.taskmanagement.service.impl;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import com.zastupailo.spring.taskmanagement.repository.IProjectRepository;
import com.zastupailo.spring.taskmanagement.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectRepository projectRepo;

    public ProjectServiceImpl(IProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }
}
