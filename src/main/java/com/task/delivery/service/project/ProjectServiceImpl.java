package com.task.delivery.service.project;

import com.task.delivery.model.Project;
import com.task.delivery.service.helper.AbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("projectService")
public class ProjectServiceImpl extends AbstractServiceImpl<Project> implements ProjectService {

    private final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

}
