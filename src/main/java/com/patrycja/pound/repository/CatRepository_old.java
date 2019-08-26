package com.patrycja.pound.repository;

import com.patrycja.pound.models.Cat;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CatRepository_old {

    @PersistenceContext
    private EntityManager entityManager;

    private Map<Integer, Cat> catsList = new HashMap<>();

    public CatRepository_old() {
    }

    @Transactional
    public void addCat(Cat cat) {
        entityManager.persist(cat);
    }

    public Map<Integer, Cat> getAllCats() {
        return catsList;
    }

    public Cat getCat(int id) {
        return catsList.get(id);
    }

    public String getCatName(int id) {
        return catsList.get(id).getName();
    }

//    @PostConstruct
//    private void build() {
//        addCat(new Cat(counter.get(), "Sara", 2, CatColor.WHITE));
//        addCat(new Cat(counter.get(), "Ramona", 6, CatColor.BLACK));
//        addCat(new Cat(counter.get(), "Kimmy", 1, CatColor.GREY));
//        addCat(new Cat(counter.get(), "Rob", 8, CatColor.PINK));
//        addCat(new Cat(counter.get(), "Jessy", 12, CatColor.PINK));
//        addCat(new Cat(counter.get(), "John", 7, CatColor.WHITE));
//        addCat(new Cat(counter.get(), "Merry", 7, CatColor.YELLOW));
//        addCat(new Cat(counter.get(), "Creig", 2, CatColor.WHITE));
//        addCat(new Cat(counter.get(), "Anton", 1, CatColor.YELLOW));
//    }

    public void deleteCat(int id) {
        catsList.remove(id);
    }

    @Override
    public String toString() {
        return "CatRepository{" +
                "catsList=" + catsList +
                '}';
    }
}
