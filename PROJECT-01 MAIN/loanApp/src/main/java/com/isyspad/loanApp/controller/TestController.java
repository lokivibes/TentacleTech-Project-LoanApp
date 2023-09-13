package com.isyspad.loanApp.controller;

import com.isyspad.loanApp.model.TestDemo;
import com.isyspad.loanApp.model.TestDemoResp;
import com.isyspad.loanApp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping(path ="/testApi")
    public String firstApi(String test){
        String resp = "Success";
        return resp;
    }

    @PostMapping(path ="/testApi2")
    public TestDemoResp firstApi(@RequestBody TestDemo reqDemo){
        TestDemoResp testDemoResp = new TestDemoResp();
        testDemoResp = testService.getResp(reqDemo);

        return testDemoResp;
    }
}
