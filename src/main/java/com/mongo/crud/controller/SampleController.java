package com.mongo.crud.controller;

import com.mongo.crud.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class SampleController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleService sampleService;

    @PostMapping("/sample")
    public ResponseEntity<String> saveSample(@RequestParam("file") MultipartFile file) throws IOException {
        if(file == null && file.isEmpty()) {
            return new ResponseEntity<>("file can not be empty or null", HttpStatus.BAD_REQUEST);
        }
        sampleService.sampleService(file);
        return new ResponseEntity<>("Successfully saved to mongo db", HttpStatus.CREATED);
    }
}
