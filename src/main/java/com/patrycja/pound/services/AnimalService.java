package com.patrycja.pound.services;

import com.patrycja.pound.models.Animal;
import com.patrycja.pound.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAnimals(){
        return animalRepository.findAll();
    }
}
