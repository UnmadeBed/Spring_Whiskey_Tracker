package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;


    @GetMapping()
    public ResponseEntity findByYear(@RequestParam(name="year", required = false) Integer year){
        if(year != null){
            return new ResponseEntity(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/specific")
    public ResponseEntity findByDistilleryNameAndAge(
            @RequestParam(name = "distillery", required = false) String distilleryName,
            @RequestParam(name = "age", required = false) Integer age
    ){
        return new ResponseEntity(whiskyRepository.findByDistilleryNameAndAge(distilleryName, age), HttpStatus.OK);
    }

}
