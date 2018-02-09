package com.task.delivery.repository;

import com.task.delivery.model.Project;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

public interface ProjectRepository extends Repository<Project, String> {

    @Transactional(readOnly = true)
    Collection<Project> findByName(@Param("name") String name);

    void save(Project project);
}
