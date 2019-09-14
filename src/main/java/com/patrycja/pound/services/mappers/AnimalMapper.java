package com.patrycja.pound.services.mappers;

import com.patrycja.pound.models.domain.Animal;
import com.patrycja.pound.models.dto.AnimalDTO;
import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {

    public AnimalDTO map(Animal animal){
        return AnimalDTO.builder()
                .id(animal.getId())
                .age(animal.getAge())
                .name(animal.getName())
                .type(animal.getClass().getSimpleName())
                .zookeeper(animal.getZookeeper().getName())
                .build();
    }
}
