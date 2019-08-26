package com.patrycja.pound.resource;

import com.patrycja.pound.models.Animal;
import com.patrycja.pound.services.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalResource {

    private AnimalService animalService;

    public AnimalResource(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAll(){
        System.out.println("ALL :" + animalService.getAnimals());
        return animalService.getAnimals();
    }
}
