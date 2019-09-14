package com.patrycja.pound.services.mappers;

import com.patrycja.pound.models.domain.Dog;
import com.patrycja.pound.models.dto.DogDTO;
import org.springframework.stereotype.Component;

@Component
public class DogMapper {

    public DogDTO map(Dog dog) {
        return DogDTO.builder()
                .id(dog.getId())
                .numberOfTooth(dog.getNumberOfTooth())
                .name(dog.getName())
                .age(dog.getAge())
                .zookeeperName(dog.getZookeeper().getName())
                .build();
    }

    public Dog map(DogDTO dogDTO){
        return Dog.dogBuilder()
                .numberOfTooth(dogDTO.getNumberOfTooth())
                .name(dogDTO.getName())
                .age(dogDTO.getAge())
                .build();
    }

}
