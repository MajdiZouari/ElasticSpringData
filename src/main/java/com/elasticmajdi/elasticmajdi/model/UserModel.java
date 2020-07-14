package com.elasticmajdi.elasticmajdi.model;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Document(indexName = "users")
public class UserModel {
    private UUID id;
    private String firstName;
    private String lastName;
}
