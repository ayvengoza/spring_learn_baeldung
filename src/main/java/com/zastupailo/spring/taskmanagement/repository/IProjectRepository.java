package com.zastupailo.spring.taskmanagement.repository;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IProjectRepository extends PagingAndSortingRepository<Project, Long> {

    Optional<Project> findByName(String name);

    List<Project> findByDateCreatedBetween(LocalDate start, LocalDate end);
}
