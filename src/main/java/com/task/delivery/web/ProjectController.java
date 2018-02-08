package com.task.delivery.web;

<<<<<<< HEAD
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
=======
import com.task.delivery.model.Project;
import com.task.delivery.service.project.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Map;
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5

@Controller
public class ProjectController {

<<<<<<< HEAD
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

=======
    private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project",method = RequestMethod.GET)
    public String list(Map<String, Object> model) {
        List<Project> project = projectService.list();
        model.put("project", project);
        model.put("active", "project");
        return "resources/templates/project/project";
    }

    @RequestMapping(value = "/project", method = RequestMethod.PUT)
    public ModelAndView add(ModelMap model, String name) {
        try {
            if (StringUtils.isNoneBlank(name)) {
                Project project = new Project(name);
                projectService.save(project);
                model.put("success", true);
            }
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            model.put("success", false);
            model.put("error", e.getMessage());
        }
        return new ModelAndView("redirect:/dashboard", model);
    }
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5

}

