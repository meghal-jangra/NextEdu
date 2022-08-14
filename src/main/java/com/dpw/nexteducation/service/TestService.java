package com.dpw.nexteducation.service;

import com.dpw.nexteducation.entity.Result;
import com.dpw.nexteducation.entity.Test;
import com.dpw.nexteducation.repository.ResultRepository;
import com.dpw.nexteducation.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private ResultRepository resultRepository;

    public List<Test> getAllTest() {
        List<Test> tests = new ArrayList<>();
        testRepository.findAll().forEach(tests::add);
        return tests;
    }

    public void addTest(Test test) {
        testRepository.save(test);
    }

    public Test declareResultToTest(int testId, int resultId){
        Test test = testRepository.findById(testId).get();
        Result result = resultRepository.findById(resultId).get();
        test.declareResult(result);
        return testRepository.save(test);
    }
}
