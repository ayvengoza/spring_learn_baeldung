package com.zastupailo.spring.taskmanagement.client;

import com.zastupailo.spring.taskmanagement.web.dto.ProjectDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.*;

@SpringBootTest
public class ProjectRestApiLiveTest {
    private static final String BASE_URL = "http://localhost:8080/api/projects/";
    private RestTemplate restTemplate = new RestTemplate();


    @Test
    public void givenProjectExist_whenGet_thenSuccess() {
        ResponseEntity<ProjectDto> response = restTemplate.getForEntity(BASE_URL + "1", ProjectDto.class);
        assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        assertNotNull(response.getBody());
    }

    @Test
    public void givenNewProject_whenPost_thenSuccess() {
        ProjectDto dto = new ProjectDto();
        dto.setId(new Random().nextLong());
        dto.setName(randomAlphabetic(6));

        ResponseEntity<Void> response = restTemplate.postForEntity(BASE_URL, dto, Void.class);
        assertTrue(response.getStatusCode() == HttpStatus.OK);
    }
}
