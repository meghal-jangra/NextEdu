package com.dpw.nexteducation.subject;

import com.dpw.nexteducation.student.Student;
import com.dpw.nexteducation.student.StudentRepository;
import com.dpw.nexteducation.teacher.Teacher;
import com.dpw.nexteducation.teacher.TeacherRepository;
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
