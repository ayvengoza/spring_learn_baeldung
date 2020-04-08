package com.zastupailo.spring.taskmanagement.repository;

import com.zastupailo.spring.taskmanagement.persistence.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ITaskRepositoryIntegrationTest {

    @Autowired
    private ITaskRepository taskRepository;

    @Test
    public void givenProjectCreated_thenFindByTaskNameMatchesSuccess() {
        Task task1 = new Task("Low Priority Task", "Low Priority Task", LocalDate.now(), LocalDate.now());
        Task task2 = new Task("Low Priority Task", "Low Priority Task", LocalDate.now(), LocalDate.now());
        Task task3 = new Task("High Priority Task", "High Priority Task", LocalDate.now(), LocalDate.now());
        Task task4 = new Task("High Priority Task", "High Priority Task", LocalDate.now(), LocalDate.now());

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);

        List<Task> retrievedTasks = taskRepository.findByNameMatches("High");
        assertEquals(retrievedTasks.size(), 2);
    }
}