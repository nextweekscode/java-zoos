package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal extends Auditable {

    /**
     * The primary key (long) of the animals table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    /**
     * The type (String) of the animal. Cannot be null and must be unique.
     */
    @Column(nullable = false,
            unique = true)
    private String animaltype;

    /**
     * Creates a join table joining Users and Roles in a Many-To-Many relations.
     * Contains a List of Users Objects using this Role.
     */
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "animal")
    private Set<ZooAnimals> zoos = new HashSet<>();

    public Animal() {
        // Default constructor for JPA
    }

    public Animal(long animalid, String animaltype) {
        this.animalid = animalid;
        this.animaltype = animaltype;
    }

    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public Set<ZooAnimals> getZoos() {
        return zoos;
    }

    public void setZoos(Set<ZooAnimals> zoos) {
        this.zoos = zoos;
    }
}