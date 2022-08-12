package com.dpw.nexteducation.controller;

import com.dpw.nexteducation.entity.Subject;
import com.dpw.nexteducation.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {


    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public void addSubjects(@RequestBody Subject subject){
        subjectService.addSubjects(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    public Subject enrolledStudentToSubject(@PathVariable int subjectId, @PathVariable int studentId){
        return subjectService.enrollStudent(subjectId,studentId);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    public Subject assignTeacherToSubject(@PathVariable int subjectId, @PathVariable int teacherId){
        return subjectService.assignTeacher(subjectId,teacherId);
    }
}
