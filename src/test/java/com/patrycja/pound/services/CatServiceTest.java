package com.patrycja.pound.services;

import com.patrycja.pound.enums.CatColor;
import com.patrycja.pound.models.domain.Cat;
import com.patrycja.pound.models.domain.Zookeeper;
import com.patrycja.pound.models.dto.CatDTO;
import com.patrycja.pound.repository.CatRepository;
import com.patrycja.pound.services.mappers.CatMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatServiceTest {

    private Cat cat;

    @Mock
    CatRepository catRepository;
    @Mock
    CatMapper catMapper;
    @Mock
    AnimalService animalService;
    @Mock
    ZookeeperService zookeeperService;

    @InjectMocks
    CatService catService;

    public CatDTO createCatDTO() {
        CatDTO catDTO = new CatDTO();
        catDTO.setName("Pimpek");
        catDTO.setAge(12);
        catDTO.setColor(CatColor.GREY);
        return catDTO;
    }

    @Before
    public void createCat() {
        cat = new Cat();
    }

    @Test
    public void getCatByIdShouldReturnCat() {
        int id = 1;
        when(catRepository.findById(id)).thenReturn(Optional.of(cat));
        Cat catById = catService.getCatById(id);
        assertThat(catById).isEqualTo(cat);
    }

    @Test
    public void updateCatShouldUpdateCatInfo() {
        CatDTO catDTO = createCatDTO();
        int id = 1;
        when(catRepository.findById(id)).thenReturn(Optional.of(cat));
        cat.setAge(catDTO.getAge());
        cat.setName(catDTO.getName());
        cat.setColor(catDTO.getColor());
        catService.updateCat(id, catDTO);
        verify(catRepository, times(id)).save(cat);
    }

    @Test
    public void getCatNameShouldReturnCatName() {
        int id = 1;
        String catName = "Pimpek";
        cat.setName(catName);
        when(catRepository.findById(id)).thenReturn(Optional.of(cat));
        String foundCat = catService.getCatName(id);
        assertThat(foundCat).isNotEqualTo(null);
        assertThat(foundCat).isEqualTo(catName);
    }

    @Test
    public void addCatShouldSaveCatToRepository() {
        CatDTO catDTO = createCatDTO();
        when(catMapper.map(catDTO)).thenReturn(cat);
        Zookeeper zookeeper = new Zookeeper();
        when(zookeeperService.findFreeZookeeper()).thenReturn(zookeeper);
        cat.setZookeeper(zookeeper);
        catService.addCat(catDTO);
        verify(catRepository, times(1)).save(cat);
        verify(zookeeperService, times(1)).saveAnimalToZookeeper(cat, zookeeper);
    }

    @Test
    public void deleteCatShouldDeleteCatFromRepository() {
        int id = 1;
        when(catRepository.getOne(id)).thenReturn(cat);
        catService.deleteCat(id);
        verify(animalService, times(1)).deleteAnimalFromZookeeper(cat);
        verify(catRepository, times(1)).delete(cat);
    }

    @Test
    public void getCatByColorShouldReturnListWithCatThisColor() {
        List<Cat> list = new ArrayList<>();
        String pink = "GREY";
        CatDTO catDTO = createCatDTO();
        int expected = 1;
        list.add(cat);
        when(catRepository.findAll()).thenReturn(list);
        when(catMapper.map(cat)).thenReturn(catDTO);
        List<CatDTO> catByColor = catService.getCatByColor(pink);
        assertThat(catByColor.size()).isEqualTo(expected);
        assertThat(catByColor.get(0).getColor().toString()).isEqualTo(pink);
    }
}
