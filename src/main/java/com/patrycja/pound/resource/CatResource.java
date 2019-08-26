package com.patrycja.pound.resource;

import com.patrycja.pound.models.Cat;
import com.patrycja.pound.models.dto.CatDTO;
import com.patrycja.pound.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatResource {

    @Autowired
    private CatService catService;

    @GetMapping
    public List<Cat> getListAllCats(@RequestParam(value = "sort", defaultValue = "") String sort) {
        return catService.getAllCats(sort);
    }

    @GetMapping("/colors/{color}")
    public List<Cat> getCatByColor(@PathVariable("color") String color) {
        return catService.getCatByColor(color);
    }

    @PostMapping
    public ResponseEntity<String> addCat(@RequestBody CatDTO catDTO) {
        return catService.addCat(catDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCat(@PathVariable("id") int id) {
        return catService.deleteCat(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCat(@PathVariable("id") int id, @RequestBody Cat cat) {
        return catService.updateCat(id, cat);
    }
}
