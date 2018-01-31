package com.task.delivery.repository;

import com.task.delivery.model.Project;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    Project findByProjectName (String project);

 //   public List<Project> findByProjectName(String projectName);

    public List<Project> findById(Long id);
}
