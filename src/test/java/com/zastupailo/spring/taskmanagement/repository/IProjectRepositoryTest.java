package com.zastupailo.spring.taskmanagement.repository;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
        Optional<Project> retrievedProject = projectRepository.findById(newProject.getId());
        assertEquals(retrievedProject.get(), newProject);
    }

    @Test
    public void giventProject_whenFindByName_thenSuccess() {
        Project newProject = new Project("project2", LocalDate.now());
        projectRepository.save(newProject);
        Optional<Project> retrievedProject = projectRepository.findByName(newProject.getName());
        assertEquals(retrievedProject.get(), newProject);
    }

    @Test
    public void giventProject_whenFindByDateCreated_thenSuccess() {
        Project oldProject = new Project(randomAlphabetic(6), LocalDate.now().minusMonths(1));
        projectRepository.save(oldProject);
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);
        List<Project> projectList = projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now());
        assertEquals(projectList.size(), 1);
    }

    private String randomAlphabetic(int count) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < count; i++){
            stringBuffer.append(65 + random.nextInt(24));
        }
        return stringBuffer.toString();
    }
}