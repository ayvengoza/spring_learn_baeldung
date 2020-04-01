package com.zastupailo.spring.taskmanagement.service.impl;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import com.zastupailo.spring.taskmanagement.repository.IProjectRepository;
import com.zastupailo.spring.taskmanagement.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepo;

    @Autowired
    private IProjectRepository projectRepo2;

    public ProjectServiceImpl() {
        System.out.println("NEW " + this.getClass());
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }

    @Autowired
    public void setProjectRepo(IProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
        System.out.println("SET " + projectRepo.getClass());
    }
}
