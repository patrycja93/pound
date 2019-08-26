package com.patrycja.pound.models;

import lombok.Getter;
import lombok.Setter;

public class Dog extends Animal {

    @Getter
    @Setter
    private int numberOfTooth;

    public Dog(String name, int age, Zookeeper zookeeper, int numberOfTooth) {
        super(name, age, zookeeper);
        this.numberOfTooth = numberOfTooth;
    }

    public Dog(String name, int age, int numberOfTooth) {
        super(name, age);
        this.numberOfTooth = numberOfTooth;
    }

}
