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
public class Classroom {

    @Id
    private int id;

    private int classroomStandard;

    @OneToMany(mappedBy = "classroom")
    @JsonIgnore
    private Set<Student> enrolledStudents = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "test_given",
            joinColumns = @JoinColumn(name = "classroom_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id")
    )
    private Set<Test> givenTest = new HashSet<>();

    public void giveTest(Test test) {
        givenTest.add(test);
    }
}
