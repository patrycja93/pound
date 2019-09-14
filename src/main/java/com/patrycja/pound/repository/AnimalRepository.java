package com.patrycja.pound.repository;

import com.patrycja.pound.models.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

/*    @Query("SELECT AGE FROM ANIMALS WHERE dtype = 'Cat'")
    List<Cat> findByType(String typeValue);*/
}
