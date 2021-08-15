package com.mongo.crud.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface SampleService {

    void sampleService(MultipartFile file) throws IOException;
}
