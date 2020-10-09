package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.models.ZooAnimals;
import com.lambdaschool.zoos.models.ZooAnimalsID;
import org.springframework.data.repository.CrudRepository;

public interface ZooAnimalsRepository extends CrudRepository<ZooAnimals, ZooAnimalsID> {
}