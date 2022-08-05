package com.dpw.nexteducation.teacher;

import com.dpw.nexteducation.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeacher() {
        List<Teacher> teacher = new ArrayList<>();
        teacherRepository.findAll().forEach(teacher::add);
        return teacher;
    }
}
