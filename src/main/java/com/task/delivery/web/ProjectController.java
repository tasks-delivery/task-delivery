package com.task.delivery.web;

import com.task.delivery.model.Project;
import com.task.delivery.repository.ProjectRepository;
import com.task.delivery.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class ProjectController  {


    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PostMapping(path = "/project", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Project> listProjects() {
        return this.projectRepository.findAll();
    }

    @GetMapping("/project")
    public String project(Model model) {
        model.addAttribute("projectName", this.projectRepository.findAll());
        return "project";
    }

    @GetMapping(path = "/project/{projectName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Project> showProjects(@PathVariable String projectName) {
        return this.projectRepository.findByProjectName(projectName);
    }
    /*
    @RequestMapping(value = {"/project"}, method = RequestMethod.GET)
    public String project(Model model) {
        model.addAttribute("projectForm", new Project());

        return "resources/templates/project/project";
    }

    @RequestMapping(value = {"/project"}, method = RequestMethod.POST)
    public String project(@ModelAttribute("projectForm") Project projectForm, Model model) {
        projectService.save(projectForm);
        return "project";
    }

*/
}

