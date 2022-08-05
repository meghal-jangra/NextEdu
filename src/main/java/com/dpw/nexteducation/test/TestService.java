package com.dpw.nexteducation.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;


    public List<Test> getAllTest() {
        List<Test> tests = new ArrayList<>();
        testRepository.findAll().forEach(tests::add);
        return tests;
    }

    public void addTest(Test test) {
        testRepository.save(test);
    }
}
