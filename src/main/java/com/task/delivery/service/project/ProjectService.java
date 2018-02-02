package com.task.delivery.service.project;

import com.task.delivery.model.Project;

public interface ProjectService {

    void save(Project project);

    Project findByProjectName(String projectName);

   // Project findById(Long id);
}
