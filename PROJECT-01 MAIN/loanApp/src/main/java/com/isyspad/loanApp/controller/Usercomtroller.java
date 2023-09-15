package com.isyspad.loanApp.controller;

import com.isyspad.loanApp.entity.User;
import com.isyspad.loanApp.model.Usermodel;
import com.isyspad.loanApp.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class Usercomtroller {
    @Autowired
    private Userservice user;

@PostMapping(path = "bankuser")
    public String createuser(@RequestBody Usermodel data){
    return user.userdata(data);
    }
    @PutMapping(path = "update")

    public String updateuser(@RequestBody Usermodel model){
    return  user.update(model);
}

    @GetMapping(path = "get/{id}")
    public User finduser(@PathVariable Long id,String username)  {
    return user.find(id);
}
}


