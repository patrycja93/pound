package com.patrycja.pound.services;

import com.patrycja.pound.models.dto.AnimalDTO;
import com.patrycja.pound.repository.AnimalRepository;
import com.patrycja.pound.services.mappers.AnimalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalMapper animalMapper;
    private final AnimalRepository animalRepository;

    public List<AnimalDTO> getAnimals() {
        return animalRepository.findAll().stream()
                .map(animalMapper::map)
                .collect(Collectors.toList());
    }


}
