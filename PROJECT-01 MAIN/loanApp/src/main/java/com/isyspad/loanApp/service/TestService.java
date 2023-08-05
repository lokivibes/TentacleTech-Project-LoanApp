package com.isyspad.loanApp.service;

import com.isyspad.loanApp.model.TestDemo;
import com.isyspad.loanApp.model.TestDemoResp;
import org.springframework.stereotype.Service;


public interface TestService {

    public String testFunction(String test);

    public TestDemoResp getResp(TestDemo tstDemo);
}
