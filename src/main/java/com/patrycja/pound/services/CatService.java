package com.patrycja.pound.services;

import com.patrycja.pound.enums.CatColor;
import com.patrycja.pound.exceptions.NotFoundArgumentException;
import com.patrycja.pound.models.Animal;
import com.patrycja.pound.models.Cat;
import com.patrycja.pound.models.Zookeeper;
import com.patrycja.pound.models.dto.CatDTO;
import com.patrycja.pound.repository.AnimalRepository;
import com.patrycja.pound.repository.CatRepository;
import com.patrycja.pound.repository.ZookeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;
    @Autowired
    private CatMapper catMapper;
    @Autowired
    private ZookeeperRepository zookeeperRepository;
    @Autowired
    private AnimalRepository animalRepository;

    public List<Cat> getAllCats(String sort) {
        List<Cat> cats = catRepository.findAll();
        if (sort.toLowerCase().equals("desc")) {
            Collections.reverse(cats);
            return cats;
        }
        return cats;
    }

    public String getCatName(int id) {
        return catRepository.findById(id)
                .map(Cat::getName)
                .orElseThrow(() -> new IllegalArgumentException("This cat do not have name."));
    }

    public Cat getCatById(int id) {
        return catRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No cat was found with this id."));
    }

    @Transactional
    public ResponseEntity<String> addCat(CatDTO catDTO) {
        Cat cat = catMapper.map(catDTO);
        //TODO: change to custom query
        Zookeeper zookeeper = getZookeeper();
        cat.setZookeeper(zookeeper);
        catRepository.save(cat);
        saveZookeeper(cat, zookeeper);
        //addAnimal(cat);
        return ResponseEntity.ok("Successfully added kitty");
    }

    private void addAnimal(Cat cat) {
        Animal animal = new Animal();
        animal.setName(cat.getName());
        animal.setAge(cat.getAge());
        animal.setZookeeper(cat.getZookeeper());
        animalRepository.save(animal);
    }

    private void saveZookeeper(Cat cat, Zookeeper zookeeper) {
        zookeeper.addAnimal(cat);
        zookeeperRepository.save(zookeeper);
    }

    private Zookeeper getZookeeper() {
        return zookeeperRepository.findAll().stream()
                .filter(z -> z.getAnimals().size() < 10)
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .orElseThrow(() -> new NotFoundArgumentException("Not found free zookeepers."));
    }

    public ResponseEntity<String> deleteCat(int id) {
        if (catRepository.getOne(id) == null) {
            return ResponseEntity.unprocessableEntity().body("Not found cat for this id.");
        }
        catRepository.deleteById(id);
        return ResponseEntity.ok("Successfully deleted kitty");
    }

    public ResponseEntity<String> updateCat(int id, Cat cat) {
        Cat updateCat = catRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No cat founded"));
        updateCat.setAge(cat.getAge());
        updateCat.setColor(cat.getColor());
        updateCat.setName(cat.getName());
        updateCat.setZookeeper(cat.getZookeeper());
        catRepository.save(updateCat);
        return ResponseEntity.ok("Cat was updated successfully.");
    }

    public List<Cat> getCatByColor(String color) {
        return getAllCats("").stream()
                .filter(c -> c.getColor() == CatColor.valueOf(color.toUpperCase()))
                .collect(Collectors.toList());
    }
}
