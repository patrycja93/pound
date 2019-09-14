package com.patrycja.pound.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DogDTO {

    private int id;
    private String name;
    private int age;
    private String zookeeperName;
    private int numberOfTooth;
}
