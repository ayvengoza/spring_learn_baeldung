package com.zastupailo.spring.taskmanagement.repository;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IProjectRepository extends CrudRepository<Project, Long> {
    Optional<Project> findById(Long id);

    Project save(Project project);
}
