package com.zastupailo.spring.taskmanagement.repository.impl;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import com.zastupailo.spring.taskmanagement.repository.IProjectRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Profile(value = "prod")
@Repository
public class ProjectRepositoryDbImpl implements IProjectRepository {
    @Override
    public Optional<Project> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Project save(Project project) {
        return null;
    }
}
