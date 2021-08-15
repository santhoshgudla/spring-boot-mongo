package com.mongo.crud.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "sample")
@Getter
@Setter
public class SampleDoc {

    @Id
    private String id;

    private String filePath;
}
