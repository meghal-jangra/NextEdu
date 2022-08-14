package com.dpw.nexteducation.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Result {

    @Id
    private int id;

    private int marksScored;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId" , referencedColumnName = "id")
    private Student student;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "result")
    private Test test;

    public void giveResultToStudent(Student student){
        this.student = student;
    }

}
