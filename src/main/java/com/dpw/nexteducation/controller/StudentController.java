package com.dpw.nexteducation.controller;

import com.dpw.nexteducation.entity.Student;
import com.dpw.nexteducation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students/produces", produces = "application/vnd.nextEdu.app-v1+json")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @GetMapping("/name/{name}")
    public Student getStudent(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable int id){
        studentService.updateStudent(student,id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/{studentId}/classroom/{classroomId}")
    public Student assignClassroomToStudent(@PathVariable int studentId, @PathVariable int classroomId){
        return studentService.assignClassroom(studentId,classroomId);
    }

}
