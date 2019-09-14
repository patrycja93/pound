package com.patrycja.pound.services.mappers;

import com.patrycja.pound.models.domain.Animal;
import com.patrycja.pound.models.domain.Zookeeper;
import com.patrycja.pound.models.dto.ZookeeperDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ZookeeperMapper {

    public ZookeeperDTO map(Zookeeper zookeeper) {
        return ZookeeperDTO.builder()
                .id(zookeeper.getId())
                .name(zookeeper.getName())
                .surname(zookeeper.getSurname())
                .animals(zookeeper.getAnimals().stream()
                        .map(Animal::getId)
                        .collect(Collectors.toList()))
                .build();
    }

    public Zookeeper map(ZookeeperDTO zookeeperDTO) {
        return Zookeeper.builder()
                .name(zookeeperDTO.getName())
                .surname(zookeeperDTO.getSurname())
                .build();
    }
}
