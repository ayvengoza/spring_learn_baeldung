package com.zastupailo.spring.taskmanagement.web.controller;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import com.zastupailo.spring.taskmanagement.service.IProjectService;
import com.zastupailo.spring.taskmanagement.web.dto.ProjectDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api/projects")
public class ProjectController {

    private IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        super();
        this.projectService = projectService;
    }

    @GetMapping(headers = "accept=application/json", value = "/{id}")
    public ProjectDto findOneJson(@PathVariable Long id) {
        Project project = projectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project Not Found"));
        return convertEntityToDto(project);
    }

    @GetMapping(headers = "accept=application/xml", value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE })
    public ProjectDto findOneXml(@PathVariable Long id) {
        Project project = projectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertEntityToDto(project);
    }

    @GetMapping(params = "paramKey=paramValue", value = "/{id}")
    public ProjectDto findOneParamFilter(@PathVariable Long id) {
        Project project = new Project("Param project", LocalDate.now());
        return convertEntityToDto(project);
    }

    @PostMapping
    public void create(@RequestBody ProjectDto projectDto) {
        projectService.save(projectDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.delete(id);
    }

    private ProjectDto convertEntityToDto(Project project) {
        return new ProjectDto(project);
    }

}
