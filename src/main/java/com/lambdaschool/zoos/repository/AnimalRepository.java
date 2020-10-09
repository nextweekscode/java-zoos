package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.views.AnimalCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query(value = "SELECT a.animaltype, a.animalid, count(za.zooid) countzoos " +
            "FROM animals a LEFT JOIN zooanimals za " +
            "ON a.animalid = za.animalid " +
            "GROUP BY a.animaltype " +
            "ORDER BY a.animaltype", nativeQuery = true)
    List<AnimalCount> animalCount();
}