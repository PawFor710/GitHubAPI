package com.pawfor.github.webclient.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRepositoryDto {
    private String name;
    private OwnerDto owner;
}
