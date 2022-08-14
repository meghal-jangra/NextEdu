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




}
