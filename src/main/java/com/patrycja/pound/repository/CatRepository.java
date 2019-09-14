package com.patrycja.pound.repository;

import com.patrycja.pound.models.domain.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {

    @Query()
    List<Cat> findByName(String name);

}
