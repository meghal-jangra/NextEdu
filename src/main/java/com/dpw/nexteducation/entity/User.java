package com.dpw.nexteducation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String address;
}
