package com.dpw.nexteducation.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @GetMapping("/students/name/{name}")
    public Student getStudent(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable int id){
        studentService.updateStudent(student,id);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/{studentId}/classroom/{classroomId}")
    public Student assignClassroomToStudent(@PathVariable int studentId, @PathVariable int classroomId){
        return studentService.assignClassroom(studentId,classroomId);
    }

}
