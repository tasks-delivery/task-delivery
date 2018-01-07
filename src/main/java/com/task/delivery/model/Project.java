package com.task.delivery.model;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    private Long id;
    private String projectName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


}
