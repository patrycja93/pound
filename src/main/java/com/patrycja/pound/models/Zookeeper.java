package com.patrycja.pound.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "zookeepers")
public class Zookeeper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Animal> animals;

    public Zookeeper() {
    }

    public Zookeeper(int id, String name, String surname, List<Animal> animals) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.animals = animals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
}
