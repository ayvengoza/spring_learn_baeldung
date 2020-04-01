package com.zastupailo.spring.taskmanagement.configuration;

import com.zastupailo.spring.taskmanagement.repository.impl.ProjectRepositoryImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicConfig {

//    @Bean
    public ProjectRepositoryImpl projectRepository() {
        return new ProjectRepositoryImpl();
    }

//    @Bean
    public ProjectRepositoryImpl projectRepository2() {
        return new ProjectRepositoryImpl();
    }
}
