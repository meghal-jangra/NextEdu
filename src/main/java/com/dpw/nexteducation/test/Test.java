package com.dpw.nexteducation.test;

import com.dpw.nexteducation.classroom.Classroom;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    @Id
    private int id;

    private String category;

    @JsonIgnore
    @ManyToMany(mappedBy = "givenTest")
    private Set<Classroom> subjects = new HashSet<>();
}
