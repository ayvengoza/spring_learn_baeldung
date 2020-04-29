package com.zastupailo.spring.taskmanagement.service;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import com.zastupailo.spring.taskmanagement.web.dto.ProjectDto;

import java.util.List;
import java.util.Optional;

public interface IProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);

    Project save(ProjectDto projectDto);

    List<Project> findAll();

    void delete(Long id);
}
