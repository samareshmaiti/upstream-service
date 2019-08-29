package com.stackroute.succpur.upstreamservice.controller;


import com.stackroute.succpur.upstreamservice.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/")
public class DataController {
    private DataService dataService;
    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTrack() {
        return new ResponseEntity<>(dataService, HttpStatus.OK);
    }

}
