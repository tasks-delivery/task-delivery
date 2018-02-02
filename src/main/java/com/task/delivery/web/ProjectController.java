package com.task.delivery.web;

import com.task.delivery.model.Project;
import com.task.delivery.repository.ProjectRepository;
import com.task.delivery.service.project.ProjectService;
import com.task.delivery.validator.ProjectValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ProjectController extends HttpServlet {
/*
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/project.jsp").forward(req, resp);
    }*/


    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;


    @Autowired
    private ProjectValidation projectValidation;

    @RequestMapping(value = {"/projects"}, method = RequestMethod.GET)
    public String project(Model model) {
        model.addAttribute("projectForm", new Project());

        return "resources/templates/project/project";
    }


    @RequestMapping(value = {"/projects"}, method = RequestMethod.POST)
    public String project(@ModelAttribute("projectForm") Project projectForm, Model model) {
        projectService.save(projectForm);

        return "redirect:/dashboard";
    }

}

