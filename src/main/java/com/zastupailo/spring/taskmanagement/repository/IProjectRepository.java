package com.zastupailo.spring.taskmanagement.repository;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {
    Optional<Project> findById(Long id);

    Project save(Project project);
}
