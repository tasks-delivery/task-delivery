package com.task.delivery.web;

import com.task.delivery.repository.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
/*
    private final ProjectRepository projectRepository;

    public HomeController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    */

    @GetMapping("/")
    public String home(Model model) {
        //model.addAttribute("users", this.projectRepository.findAll());
        return "index";
    }

/*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "index";
    }
    */
}
