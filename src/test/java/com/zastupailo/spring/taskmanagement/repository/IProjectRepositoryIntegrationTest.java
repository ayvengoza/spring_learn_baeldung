package com.zastupailo.spring.taskmanagement.repository;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class IProjectRepositoryIntegrationTest {
    @Autowired
    IProjectRepository projectRepository;

    @Test
    public void givenDataCreated_whenFindAllPaginated_thenSuccess() {
        Page<Project> page = projectRepository.findAll(PageRequest.of(0, 2));
        assertThat(page.getContent(), hasSize(2));
    }

    @Test
    public void givenDataCreated_whenFindAllSorted_thenSuccess() {
        List<Project> retrievedProjects = (List<Project>) projectRepository.findAll(Sort.by(Sort.Order.asc("name")));
        List<Project> sortedProjects = retrievedProjects.stream().collect(Collectors.toList());
        sortedProjects.sort(Comparator.comparing(Project::getName));
        assertEquals(sortedProjects, retrievedProjects);
    }

    @Test
    public void givenDataCreated_whenFindAllPaginatedAndSorted_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Order.asc("name"))));
        List<Project> sortedProjects = retrievedProjects.stream().collect(Collectors.toList());
        sortedProjects.sort(Comparator.comparing(Project::getName));

        assertThat(retrievedProjects.getContent(), hasSize(2));
        assertEquals(sortedProjects, retrievedProjects.getContent());
    }
}
