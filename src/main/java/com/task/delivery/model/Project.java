package com.task.delivery.model;

import javax.persistence.*;

@Entity
public class Project {

    public Project() { }

    public Project(String name) {
        this.name = name;
    }

    @Id
    private String name;
    public void setName(String c) {name = c;}
    public String getName() {return name ;}

    @Transient
    private String nonPersistant;
    public String getNonPersistant() { return nonPersistant; }
    public void setNonPersistant(String nonPersistant) { this.nonPersistant = nonPersistant; }

}
