package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.views.AnimalCount;

import java.util.List;

public interface AnimalServices {

    List<AnimalCount> animalCount();
}