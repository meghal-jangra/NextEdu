package com.dpw.nexteducation.classroom;

import com.dpw.nexteducation.subject.Subject;
import com.dpw.nexteducation.teacher.Teacher;
import com.dpw.nexteducation.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/classroom")
    public List<Classroom> getClassroom(){
        return classroomService.getAllClassroom();
    }

    @PostMapping("/classroom")
    public void addClassroom(@RequestBody Classroom classroom){
        classroomService.addClassroom(classroom);
    }

    @PutMapping("/{classroomId}/test/{testId}")
    public Classroom enrolledStudentToSubject(@PathVariable int classroomId, @PathVariable int testId){
        return classroomService.giveTest(classroomId,testId);
    }

}
