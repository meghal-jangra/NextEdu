package com.dpw.nexteducation.student;

import com.dpw.nexteducation.classroom.Classroom;
import com.dpw.nexteducation.subject.Subject;
import com.dpw.nexteducation.teacher.Teacher;
import com.dpw.nexteducation.user.User;
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

    public void assignClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
