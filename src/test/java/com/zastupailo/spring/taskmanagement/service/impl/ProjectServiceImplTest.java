package com.zastupailo.spring.taskmanagement.service.impl;

import com.zastupailo.spring.taskmanagement.TestConfig;
import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import com.zastupailo.spring.taskmanagement.service.IProjectService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

@SpringJUnitConfig(value = TestConfig.class)
@TestPropertySource(locations = "classpath:test.properties")
class ProjectServiceImplTest {
    @Autowired
    private IProjectService projectService;

    @Test
    void findById() {
    }

    @Test
    void save_notNull() {
        Project project = projectService.save(new Project("Name", LocalDate.now()));
        Assert.assertThat(project, is(notNullValue()));
    }
}