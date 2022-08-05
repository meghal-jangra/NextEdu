package com.dpw.nexteducation.test;

import com.dpw.nexteducation.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;


    @GetMapping("/test")
    public List<Test> getTest(){
        return testService.getAllTest();
    }

    @PostMapping("/test")
    public void addTeacher(@RequestBody Test test){
        testService.addTest(test);
    }


}
