package com.patrycja.pound.services;


import com.patrycja.pound.exceptions.NotFoundArgumentException;
import com.patrycja.pound.models.domain.Animal;
import com.patrycja.pound.models.domain.Zookeeper;
import com.patrycja.pound.models.dto.ZookeeperDTO;
import com.patrycja.pound.repository.ZookeeperRepository;
import com.patrycja.pound.services.mappers.ZookeeperMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ZookeeperService {

    private final ZookeeperRepository zookeeperRepository;
    private final ZookeeperMapper zookeeperMapper;

    public ResponseEntity<String> addZookeeper(ZookeeperDTO zookeeperDTO) {
        zookeeperRepository.save(zookeeperMapper.map(zookeeperDTO));
        return ResponseEntity.ok("Successfully added zookeeper!");
    }

    public List<ZookeeperDTO> getZookeepers() {
        List<Zookeeper> all = zookeeperRepository.findAll();
        return all.stream()
                .map(zookeeperMapper::map)
                .collect(Collectors.toList());
    }

    Zookeeper findFreeZookeeper() {
        return zookeeperRepository.findAll().stream()
                .filter(z -> z.getAnimals().size() < 10)
                .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(-1, 2))
                .findAny()
                .orElseThrow(() -> new NotFoundArgumentException("Not found free zookeepers."));
    }

    void saveAnimalToZookeeper(Animal animal, Zookeeper zookeeper) {
        zookeeper.addAnimal(animal);
        zookeeperRepository.save(zookeeper);
    }

    public String updateZookeeper(int id, ZookeeperDTO zookeeperDTO) {
        Zookeeper zookeeper = zookeeperRepository.getOne(id);
        if (zookeeper == null) {
            throw new NotFoundArgumentException("Not founded zookeepers for this id.");
        }
        zookeeper.setSurname(zookeeperDTO.getSurname());
        zookeeperRepository.save(zookeeper);
        return ResponseEntity.ok("Successfully updated zookeeper.").toString();
    }

    /*public String deleteZookeeper(int id) {

        //sprawdzic ile mial zwierzat ?
        Zookeeper zookeeper = zookeeperRepository.getOne(id);
        List<Animal> animals = zookeeper.getAnimals();
        findZookeepersForAnimals(animals);
    }*/

   /* private void findZookeepersForAnimals(List<Animal> animals) {
        if (animals.size() == 0) {
            return;
        } else {
            zookeeperRepository.findAll().stream()
                    .filter(zookeeper -> zookeeper.getAnimals().size() < 10)
                    .map(zookeeper -> )
        }
    }*/

    public void deleteAnimalFromZookeeper(Animal animal){
        zookeeperRepository.findAll().stream()
                .filter(z -> z.getAnimals().contains(animal))
                .findFirst()
                .map(z -> z.getAnimals().remove(animal))
                .orElseThrow(() -> new NotFoundArgumentException("Not found animal with this id."));
    }
}
