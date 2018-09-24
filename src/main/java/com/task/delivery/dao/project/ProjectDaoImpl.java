package com.task.delivery.dao.project;

import com.task.delivery.dao.helper.AbstractDaoImpl;
import com.task.delivery.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("projectDao")
public class ProjectDaoImpl extends AbstractDaoImpl<Project> implements ProjectDao {

  //  private final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);
}
