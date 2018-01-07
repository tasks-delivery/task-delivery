package com.task.delivery.web;

import com.task.delivery.exception.WrongIdFormatException;
import com.task.delivery.model.Project;
import com.task.delivery.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;
/*
    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public Project create(@RequestBody Project project, HttpServletResponse response){


        projectRepository.save(project);

        response.setStatus(HttpServletResponse.SC_CREATED);

        return project;
    }
*/
    @RequestMapping(value = {"/projects"}, method = RequestMethod.GET)
    public String  project(Model model){


        return "resources/templates/project/project";
    }

/*
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Contact updateClient(@PathVariable String id, @RequestBody Contact contact){

        contactRepository.save(contact);

        return contact;
    }
*/


}

