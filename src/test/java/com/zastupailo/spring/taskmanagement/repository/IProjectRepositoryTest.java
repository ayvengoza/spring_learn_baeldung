package com.zastupailo.spring.taskmanagement.repository;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class IProjectRepositoryTest {
    @Autowired
    IProjectRepository projectRepository;

    @Test
    public void whenSaveNewProject_thenSuccess() {
        Project newProject = new Project("project", LocalDate.now());
        assertNotNull(projectRepository.save(newProject));
    }

    @Test
    public void giventProject_whenFindById_thenSuccess() {
        Project newProject = new Project("project2", LocalDate.now());
        projectRepository.save(newProject);
        Optional<Project> retreivedProject = projectRepository.findById(newProject.getId());
        assertEquals(retreivedProject.get(), newProject);
    }
}