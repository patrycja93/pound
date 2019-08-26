package com.patrycja.pound.models.dto;

import com.patrycja.pound.enums.CatColor;

public class CatDTO {

    private String name;
    private int age;
    private CatColor color;

    public CatDTO(String name, int age, CatColor color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CatColor getColor() {
        return color;
    }

    public void setColor(CatColor color) {
        this.color = color;
    }
}
