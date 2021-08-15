package com.mongo.crud.repository;

import com.mongo.crud.domain.SampleDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SampleRepository extends MongoRepository<SampleDoc, String> {
}
