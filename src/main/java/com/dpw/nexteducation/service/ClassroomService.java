package com.dpw.nexteducation.service;

import com.dpw.nexteducation.repository.ClassroomRepository;
import com.dpw.nexteducation.entity.Classroom;
import com.dpw.nexteducation.entity.Test;
import com.dpw.nexteducation.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private TestRepository testRepository;


    public List<Classroom> getAllClassroom() {
        List<Classroom> classrooms = new ArrayList<>();
        classroomRepository.findAll().forEach(classrooms::add);
        return classrooms;
    }

    public void addClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    public Classroom giveTest(int classroomId, int testId) {
        Classroom classroom = classroomRepository.findById(classroomId).get();
        Test test = testRepository.findById(testId).get();
        classroom.giveTest(test);
        return classroomRepository.save(classroom);
    }
}
