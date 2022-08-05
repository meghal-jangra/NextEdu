package com.dpw.nexteducation.subject;

import com.dpw.nexteducation.student.Student;
import com.dpw.nexteducation.teacher.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Subject {

    @Id
    private int id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;
    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> enrolledStudents = new HashSet<>();

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
