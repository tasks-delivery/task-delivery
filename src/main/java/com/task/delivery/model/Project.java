package com.task.delivery.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "project")
public class Project {

    public Project() { }

    public Project(String name) {
        this.name = name;
    }

    @Id
    @Size(min = 2, max = 20,message = "Please use between 2 and 20 characters.")
    private String name;
    public void setName(String c) {name = c;}
    public String getName() {return name ;}

    @Transient
    private String nonPersistant;
    public String getNonPersistant() { return nonPersistant; }
    public void setNonPersistant(String nonPersistant) { this.nonPersistant = nonPersistant; }

}
