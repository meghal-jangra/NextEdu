package com.dpw.nexteducation.controller;

import com.dpw.nexteducation.entity.Test;
import com.dpw.nexteducation.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;


    @GetMapping
    public List<Test> getTest(){
        return testService.getAllTest();
    }

    @PostMapping
    public void addTest(@RequestBody Test test){
        testService.addTest(test);
    }
}
