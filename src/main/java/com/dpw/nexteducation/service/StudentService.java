package com.dpw.nexteducation.service;

import com.dpw.nexteducation.entity.Classroom;
import com.dpw.nexteducation.repository.ClassroomRepository;
import com.dpw.nexteducation.entity.Student;
import com.dpw.nexteducation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    public List<Student> getAllStudents(){

        List<Student> students = new ArrayList<>();

        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Student getStudent(int id){
        
        return studentRepository.findById(id).get();
    }


    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student, int id) {
        studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public Student assignClassroom(int studentId, int classroomId) {
        Student student = studentRepository.findById(studentId).get();
        Classroom classroom = classroomRepository.findById(classroomId).get();
        student.assignClassroom(classroom);
        return studentRepository.save(student);
    }
}
