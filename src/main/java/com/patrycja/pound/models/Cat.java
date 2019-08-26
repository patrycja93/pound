package com.patrycja.pound.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.patrycja.pound.enums.CatColor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Cat extends Animal {

    @Enumerated(EnumType.STRING)
    private CatColor color;

    public Cat() {
    }

    public Cat(String name, int age, CatColor color) {
        super(name, age);
        this.color = color;
    }

    private Cat(String name, int age, Zookeeper zookeeper, CatColor color) {
        super(name, age, zookeeper);
        this.color = color;
    }

    public CatColor getColor() {
        return color;
    }

    public void setColor(CatColor color) {
        this.color = color;
    }

    public static class CatBuilder {

        private String name;
        private int age;
        private CatColor color;
        private Zookeeper zookeeper;

        public Cat build() {
            return new Cat(name, age, zookeeper, color);
        }

        public CatBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CatBuilder age(int age) {
            this.age = age;
            return this;
        }

        public CatBuilder color(CatColor color) {
            this.color = color;
            return this;
        }

        public CatBuilder zookeeper(Zookeeper zookeeper) {
            this.zookeeper = zookeeper;
            return this;
        }
    }
}
