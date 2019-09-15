package com.patrycja.pound.services;

import com.patrycja.pound.models.domain.Animal;
import com.patrycja.pound.models.domain.Cat;
import com.patrycja.pound.models.domain.Dog;
import com.patrycja.pound.models.domain.Zookeeper;
import com.patrycja.pound.models.dto.ZookeeperDTO;
import com.patrycja.pound.repository.ZookeeperRepository;
import com.patrycja.pound.services.mappers.ZookeeperMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ZookeeperServiceTest {

    @Mock
    ZookeeperRepository zookeeperRepository;
    @Mock
    ZookeeperMapper zookeeperMapper;
    @InjectMocks
    ZookeeperService zookeeperService;

    @Test
    public void getZookeepersShouldReturnAllZookeepers() {
        List<Zookeeper> zookeepers = new ArrayList<>();
        Zookeeper zookeeper = new Zookeeper();
        ZookeeperDTO zookeeperDTO = new ZookeeperDTO();
        zookeepers.add(zookeeper);
        when(zookeeperRepository.findAll()).thenReturn(zookeepers);
        when(zookeeperMapper.map(zookeeper)).thenReturn(zookeeperDTO);
        List<ZookeeperDTO> zookeepersList = zookeeperService.getZookeepers();
        assertThat(zookeepersList.size()).isEqualTo(1);
        assertThat(zookeepersList.get(0)).isNotNull();
    }

    @Test
    public void updateZookeeperShouldChangeZookeeperData() {
        Zookeeper zookeeper = new Zookeeper();
        ZookeeperDTO zookeeperDTO = new ZookeeperDTO();
        zookeeperDTO.setSurname("Perkins");
        int id = 1;
        when(zookeeperRepository.getOne(id)).thenReturn(zookeeper);
        zookeeperService.updateZookeeper(id, zookeeperDTO);
        verify(zookeeperRepository, times(1)).save(zookeeper);
        assertThat(zookeeper.getSurname()).isEqualTo(zookeeperDTO.getSurname());
    }

    @Test
    public void addZookeeperShouldAddZookeeperToRepository() {
        ZookeeperDTO zookeeperDTO = new ZookeeperDTO();
        Zookeeper zookeeper = new Zookeeper();
        when(zookeeperMapper.map(zookeeperDTO)).thenReturn(zookeeper);
        zookeeperService.addZookeeper(zookeeperDTO);
        verify(zookeeperRepository, times(1)).save(zookeeper);
    }

    @Test
    public void deleteAnimalFromZookeeperShouldDeleteAnimalFromZookeeperList() {
        List<Zookeeper> zookeepers = new ArrayList<>();
        Animal animal = new Animal();
        Zookeeper zookeeper = new Zookeeper();
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        zookeeper.setAnimals(animals);
        zookeepers.add(zookeeper);
        when(zookeeperRepository.findAll()).thenReturn(zookeepers);
        zookeeperService.deleteAnimalFromZookeeper(animal);
        assertThat(zookeeper.getAnimals().size()).isEqualTo(0);
    }

    @Test
    public void saveAnimalToZookeeperShouldAddAnimalToZookeeperListOfAnimals() {
        Zookeeper zookeeper = new Zookeeper();
        List<Animal> animals = new ArrayList<>();
        zookeeper.setAnimals(animals);
        Dog dog = new Dog();
        dog.setId(1);
        dog.setNumberOfTooth(6);
        dog.setName("Pimpek");
        dog.setAge(4);
        zookeeperService.saveAnimalToZookeeper(dog, zookeeper);
        verify(zookeeperRepository, times(1)).save(zookeeper);
        assertThat(zookeeper.getAnimals().get(0)).isEqualTo(dog);
    }

    @Test
    public void findFreeZookeeperShouldReturnZookeeperWithAnimalListLessThanTen() {
        List<Zookeeper> zookeeperList = new ArrayList<>();
        Zookeeper zookeeper = new Zookeeper();
        Animal animal = new Cat();
        zookeeper.setAnimals(Collections.singletonList(animal));
        zookeeperList.add(zookeeper);
        when(zookeeperRepository.findAll()).thenReturn(zookeeperList);
        Zookeeper freeZookeeper = zookeeperService.findFreeZookeeper();
        assertThat(freeZookeeper).isNotNull();
    }
}