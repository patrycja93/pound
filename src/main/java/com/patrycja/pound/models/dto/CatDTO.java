package com.patrycja.pound.models.dto;

import com.patrycja.pound.enums.CatColor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CatDTO {

    private int id;
    private String name;
    private int age;
    private CatColor color;
    private String zookeeperName;
}
