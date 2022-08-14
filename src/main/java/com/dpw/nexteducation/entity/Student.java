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
public class Student extends User{

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Subject> subjects = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    private Classroom classroom;

    @ManyToMany
    @JoinTable(
            name = "test_given",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id")
    )
    private Set<Test> givenTest = new HashSet<>();


    @OneToMany(mappedBy = "student")
    private Set<Result> results = new HashSet<>();

    public void giveTest(Test test) {
        givenTest.add(test);
    }
    public void assignClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
