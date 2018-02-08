package com.task.delivery.web;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
=======
import com.task.delivery.model.Project;
import com.task.delivery.service.project.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5

@Controller
public class DashboardController {

<<<<<<< HEAD
    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String dashboard() {
=======
    @Autowired
    ProjectService projectService;

    private final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping("/dashboard")
    public String dashboard(Map<String, Object> model) {
        model.put("active", "accueil");
        List<Project> project = projectService.list();
        model.put("project", project);
        model.put("active", "project");
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5
        return "resources/templates/dashboard/dashboard";
    }

}
