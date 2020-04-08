package com.zastupailo.spring.taskmanagement.configuration;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import com.zastupailo.spring.taskmanagement.repository.IProjectRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProjectConfig implements ApplicationContextAware {

    @Autowired
    IProjectRepository projectRepository;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        projectRepository.save(new Project("Project 1", LocalDate.now()));
        projectRepository.save(new Project("Project 2", LocalDate.now()));
        projectRepository.save(new Project("Project 3", LocalDate.now()));
        projectRepository.save(new Project("Project 4", LocalDate.now()));
    }
}
