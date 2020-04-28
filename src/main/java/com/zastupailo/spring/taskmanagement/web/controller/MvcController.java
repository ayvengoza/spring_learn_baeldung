package com.zastupailo.spring.taskmanagement.web.controller;

import com.zastupailo.spring.taskmanagement.persistence.model.Project;
import com.zastupailo.spring.taskmanagement.service.IProjectService;
import com.zastupailo.spring.taskmanagement.web.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class MvcController {

    @Autowired
    private IProjectService projectService;

    @GetMapping
    public String getProjects(Model model) {
        List<Project> allProjects = projectService.findAll();
        List<ProjectDto> dtos = allProjects
                .stream()
                .map(project -> new ProjectDto(project))
                .collect(Collectors.toList());

        model.addAttribute("projects", dtos);
        return "projects";
    }

    @PostMapping("/project")
    public String addProject(@Valid @ModelAttribute("project") ProjectDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_project";
        }
        projectService.save(dto);
        return "redirect:/";
    }

    @GetMapping("new")
    public String newProject(Model model){
        model.addAttribute("project", new ProjectDto());
        return "new_project";
    }
}
