package com.patrycja.pound.services;

import com.patrycja.pound.models.Cat;
import com.patrycja.pound.models.dto.CatDTO;
import org.springframework.stereotype.Component;

@Component
public class CatMapper {


    public Cat map(CatDTO catDTO) {
        return new Cat.CatBuilder()
                .name(catDTO.getName())
                .age(catDTO.getAge())
                .color(catDTO.getColor())
                .build();
    }
}
