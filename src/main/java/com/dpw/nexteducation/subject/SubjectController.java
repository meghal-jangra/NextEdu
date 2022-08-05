package com.dpw.nexteducation.subject;

import com.dpw.nexteducation.teacher.Teacher;
import com.dpw.nexteducation.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {


    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public List<Subject> getSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping("/subjects")
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
