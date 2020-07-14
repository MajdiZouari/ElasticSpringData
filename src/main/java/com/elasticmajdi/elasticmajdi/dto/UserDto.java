package com.elasticmajdi.elasticmajdi.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserDto {

    private UUID id;
    private String firstName;
    private String lastName;
}

