package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.repository.AnimalRepository;
import com.lambdaschool.zoos.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "animalServices")
public class AnimalServicesImpl implements AnimalServices {

    @Autowired
    AnimalRepository animalrepo;

    @Override
    public List<AnimalCount> animalCount() {
        return animalrepo.animalCount();
    }
}
