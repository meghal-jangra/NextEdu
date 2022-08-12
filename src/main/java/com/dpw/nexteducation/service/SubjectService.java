package com.dpw.nexteducation.service;

import com.dpw.nexteducation.entity.Student;
import com.dpw.nexteducation.entity.Subject;
import com.dpw.nexteducation.repository.StudentRepository;
import com.dpw.nexteducation.entity.Teacher;
import com.dpw.nexteducation.repository.SubjectRepository;
import com.dpw.nexteducation.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjectRepository.findAll().forEach(subjects::add);
        return subjects;
    }

    public void addSubjects(Subject subject) {
        subjectRepository.save(subject);
    }

    public Subject enrollStudent(int subjectId, int studentId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.enrollStudent(student);
        return subjectRepository.save(subject);
    }

    public Subject assignTeacher(int subjectId, int teacherId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.assignTeacher(teacher);
        return subjectRepository.save(subject);
    }
}
