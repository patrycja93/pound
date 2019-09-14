package com.patrycja.pound.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ZookeeperDTO {

    private int id;
    private String name;
    private String surname;
    private List<Integer> animals;
}
