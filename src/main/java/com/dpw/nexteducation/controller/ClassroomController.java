package com.dpw.nexteducation.controller;

import com.dpw.nexteducation.entity.Classroom;
import com.dpw.nexteducation.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping
    public List<Classroom> getClassroom(){
        return classroomService.getAllClassroom();
    }

    @PostMapping
    public void addClassroom(@RequestBody Classroom classroom){
        classroomService.addClassroom(classroom);
    }



}
