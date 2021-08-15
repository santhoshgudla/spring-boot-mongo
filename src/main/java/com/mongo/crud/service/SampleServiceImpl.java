package com.mongo.crud.service;

import com.mongo.crud.domain.SampleDoc;
import com.mongo.crud.repository.SampleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class SampleServiceImpl implements SampleService {

    private final static Logger LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);

    @Autowired
    private SampleRepository sampleRepository;

    @Override
    public void sampleService(MultipartFile file) throws IOException {
        String uuId = UUID.randomUUID().toString();
        Path path = Paths.get("uploads"+ uuId);
        Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
        SampleDoc sampleDoc = new SampleDoc();
        sampleDoc.setFilePath(path.resolve(file.getOriginalFilename()).toString());
        sampleRepository.save(sampleDoc);
    }
}
