package com.dpw.nexteducation.service;

import com.dpw.nexteducation.entity.*;
import com.dpw.nexteducation.repository.ResultRepository;
import com.dpw.nexteducation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Result> getAllResult() {
        List<Result> results = new ArrayList<>();
        resultRepository.findAll().forEach(results::add);
        return results;
    }

    public void addResult(Result result) {
        resultRepository.save(result);
    }

    public Result giveResult(int resultId, int studentId) {
        Result result = resultRepository.findById(resultId).get();
        Student student = studentRepository.findById(studentId).get();
        result.giveResultToStudent(student);
        return resultRepository.save(result);
    }
}
