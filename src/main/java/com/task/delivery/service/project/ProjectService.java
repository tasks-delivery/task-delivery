package com.task.delivery.service.project;

import com.task.delivery.model.Project;
import reactor.core.publisher.Mono;

public interface ProjectService {

    void save(Project project);

    Mono<Project> findByProjectName(String projectName);

   // Project findById(Long id);
}
