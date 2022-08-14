package com.dpw.nexteducation.controller;

import com.dpw.nexteducation.entity.Result;
import com.dpw.nexteducation.entity.Subject;
import com.dpw.nexteducation.entity.Test;
import com.dpw.nexteducation.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping
    public List<Result> getResult(){
        return resultService.getAllResult();
    }

    @PostMapping
    public void addResult(@RequestBody Result result){
        resultService.addResult(result);
    }

    @PutMapping("/{resultId}/student/{studentId}")
    public Result giveResultToStudent(@PathVariable int resultId, @PathVariable int studentId){
        return resultService.giveResult(resultId,studentId);
    }

}
