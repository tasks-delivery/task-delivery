package com.task.delivery.repository;

import com.task.delivery.model.Project;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProjectRepository extends ReactiveMongoRepository<Project, String> {

    Mono<Project> findByProjectName(String projectName);

}
