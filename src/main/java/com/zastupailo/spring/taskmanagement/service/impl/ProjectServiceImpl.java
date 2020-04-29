package com.zastupailo.spring.taskmanagement.service.impl;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import com.zastupailo.spring.taskmanagement.repository.IProjectRepository;
import com.zastupailo.spring.taskmanagement.service.IProjectService;
import com.zastupailo.spring.taskmanagement.web.dto.ProjectDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProjectServiceImpl implements IProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private IProjectRepository projectRepo;

    public ProjectServiceImpl() {
        LOG.debug("NEW {}", this.getClass());
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public Project save(ProjectDto projectDto) {
        Project project = convertDtoToEntity(projectDto);
        return save(project);
    }

    @Override
    public List<Project> findAll() {
        return StreamSupport.stream(projectRepo.findAll().spliterator(), false).collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {
        projectRepo.deleteById(id);
    }

    private Project convertDtoToEntity(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setId(projectDto.getId());
        return project;
    }

}
