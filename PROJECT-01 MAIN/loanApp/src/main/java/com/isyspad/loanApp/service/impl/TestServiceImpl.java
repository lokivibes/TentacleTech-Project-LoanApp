package com.isyspad.loanApp.service.impl;

import com.isyspad.loanApp.entity.User;
import com.isyspad.loanApp.model.TestDemo;
import com.isyspad.loanApp.model.TestDemoResp;
import com.isyspad.loanApp.repository.UserRepository;
import com.isyspad.loanApp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String testFunction(String test) {
        String res = test.substring(5,9);
        res=res+" success";
        System.out.println(test);
        return res;
    }

    @Override
    public TestDemoResp getResp(TestDemo tstDemo) {
        TestDemoResp testDemoResp = new TestDemoResp();

        Optional<User> user = userRepository.findById(1L);
        userSave();
        List<User> userList = userRepository.findAll();
        if (user.isPresent())
            System.out.println("User available");

        if(tstDemo.getAge()>25){
            testDemoResp.userDetailsValid=true;
        }else
            testDemoResp.userDetailsValid=false;

        return testDemoResp;
    }

    @Transactional
    public User userSave(){
        User req = new User();
        req.setEmail("test@test.com");
        req.setFullName("test user");
        req.setUserName("test");
        req.setPassword("test");
        User udt = userRepository.save(req);
return udt;
    }

}
