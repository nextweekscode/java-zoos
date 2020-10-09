package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.services.ZooServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    @Autowired
    ZooServices zooServices;

    @GetMapping(value = "/zoos", produces = {"application/json"})
    public ResponseEntity<?> findAllZoos() {
        List<Zoo> allZoosList = zooServices.findAllZoos();
        return new ResponseEntity<>(allZoosList, HttpStatus.OK);
    }

    @GetMapping(value = "/zoo/{zooID}", produces = {"application/json"})
    public ResponseEntity<?> getZooByID(@PathVariable long zooID) {
        Zoo zoo = zooServices.findZooByID(zooID);
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/zoo/{zooID}")
    public ResponseEntity<?> deleteZooByID(@PathVariable long zooID) {
        zooServices.deleteZooByID(zooID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
