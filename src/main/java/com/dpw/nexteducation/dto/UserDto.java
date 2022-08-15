package com.dpw.nexteducation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
public class UserDto {
    @Id
    private int id;
    private String name;
    private String address;
}
