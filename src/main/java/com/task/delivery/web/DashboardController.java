package com.task.delivery.web;

import com.task.delivery.model.Project;
import com.task.delivery.service.project.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {

    @Autowired
    ProjectService projectService;

    private final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping("/dashboard")
    public String dashboard(Map<String, Object> model) {
        List<Project> project = projectService.list();
        model.put("project", project);
        model.put("active", "project");
        return "resources/templates/dashboard/dashboard";
    }

}
