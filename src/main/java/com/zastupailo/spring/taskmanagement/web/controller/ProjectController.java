package com.zastupailo.spring.taskmanagement.web.controller;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import com.zastupailo.spring.taskmanagement.service.IProjectService;
import com.zastupailo.spring.taskmanagement.web.dto.ProjectDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        super();
        this.projectService = projectService;
    }

    @GetMapping(value = "/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        Project project = projectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertEntityToDto(project);
    }

    @PostMapping
    public void create(@RequestBody ProjectDto projectDto) {
        Project project = convertDtoToEntity(projectDto);
        projectService.save(project);
    }

    private ProjectDto convertEntityToDto(Project project) {
        return new ProjectDto(project);
    }

    private Project convertDtoToEntity(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setId(projectDto.getId());
        return project;
    }
}
