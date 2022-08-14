package com.dpw.nexteducation.entity;

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
    @Column(name = "id", nullable = false)
    private int id;
    private String category;

    @JsonIgnore
    @ManyToMany(mappedBy = "givenTest")
    private Set<Student> students = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "testId")
    private Result result;

    public void declareResult(Result result){
        this.result = result;
    }


}
