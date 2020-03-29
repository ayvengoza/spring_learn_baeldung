package com.zastupailo.spring.taskmanagement.service;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;

import java.util.Optional;

public interface IProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
