package com.patrycja.pound.services.mappers;

import com.patrycja.pound.models.domain.Cat;
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

    public CatDTO map(Cat cat){
        return CatDTO.builder()
                .id(cat.getId())
                .color(cat.getColor())
                .name(cat.getName())
                .age(cat.getAge())
                .zookeeperName(cat.getZookeeper().getName())
                .build();
    }
}
