package com.task.delivery.web;


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

@Controller
public class ProjectController {

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

}

