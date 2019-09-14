package com.patrycja.pound.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDTO {

    private int id;
    private String name;
    private int age;
    private String type;
    private String zookeeper;

}
