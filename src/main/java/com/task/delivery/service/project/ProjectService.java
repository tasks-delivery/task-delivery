package com.task.delivery.service.project;

import com.task.delivery.model.Project;
import java.util.List;

public interface ProjectService {

    void save(Project project);

    List<Project> findByProjectName(String projectName);

    List<Project> findById(Long id);
}
