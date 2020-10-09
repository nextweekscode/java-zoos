package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ZooServices {

    List<Zoo> findAllZoos();

    Zoo findZooByID(long zooID);

    void deleteZooByID(long zooID);
}