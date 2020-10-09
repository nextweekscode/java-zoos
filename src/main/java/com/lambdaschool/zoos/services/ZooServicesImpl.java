package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "zooServices")
public class ZooServicesImpl implements ZooServices {

    @Autowired
    ZooRepository zoorepo;

    @Override
    public List<Zoo> findAllZoos() {
        List<Zoo> allZoosList = new ArrayList<>();
        zoorepo.findAll().iterator().forEachRemaining(allZoosList::add);
        return allZoosList;
    }

    @Override
    public Zoo findZooByID(long zooID) {
        Zoo zoo = zoorepo.findById(zooID)
                .orElseThrow(() -> new EntityNotFoundException("Zoo with ID " + zooID + " was not found."));
        return zoo;
    }

    @Transactional
    @Override
    public void deleteZooByID(long zooID) {

        zoorepo.findById(zooID)
                .orElseThrow(() -> new EntityNotFoundException("Zoo with ID " + zooID + " was not found."));
        zoorepo.deleteById(zooID);
    }
}