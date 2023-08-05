package com.isyspad.loanApp.service.impl;

import com.isyspad.loanApp.entity.User;
import com.isyspad.loanApp.exception.*;

import com.isyspad.loanApp.model.Usermodel;
import com.isyspad.loanApp.repository.UserRepository;
import com.isyspad.loanApp.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Serviceimpl implements Userservice {
    @Autowired
    UserRepository Repository;

    User user = new User();

     Set<String> isUsernamespresent = new HashSet<>();

    @Override
    public String userdata(Usermodel values) {
    String s;
        //UserRes response = new UserRes();
       try {

           if (values.getUserName() != null && values.getFullName()!=null
           && values.getCreatedBy()!=null&& values.getPassword()!=null && values.getCreatedDate()!=null
           && values.getEmail()!=null &&values.getSecurity1()!=null &&values.getSecurity2()!=null
                   &&values.getRole()!=null && values.getUpdatedBy()!=null ) {
                   if (values.getUserName().matches("^[a-zA-Z0-9]+$")){
                       if (values.getEmail().matches(".*@gmail\\.com")) {
                           if (values.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_\\-+=\\[\\]{}|;:,.<>?]).{8,}$")) {
                               int count = Repository.countByUsername(values.getUserName());
                               if (count == 0) {
                                   user.setId(values.getId());
                                   user.setRole(values.getRole());
                                   user.setUserName(values.getUserName());
                                   user.setEmail(values.getEmail());
                                   user.setUpdatedBy(values.getUpdatedBy());
                                   user.setPassword(values.getPassword());
                                   user.setCreatedBy(values.getCreatedBy());
                                   user.setCreatedDate(values.getCreatedDate());
                                   user.setSecurity1(values.getSecurity1());
                                   user.setSecurity2(values.getSecurity2());
                                   user.setAnswer1(values.getAnswer1());
                                   user.setAnswer2(values.getAnswer2());
                                   user.setFullName(values.getFullName());
                                   Repository.save(user);
                               } else {

                                   throw new AlreadrUserNameExist();
                               }

                               }else{
                                   throw new WeakPasswordException();


                           }}else {
                           throw new EmailFormateException();


                       }}else {

                       throw new UserNotValidException();
                   }}
           else {

               throw new  NullPointerException();
           }
       }catch (Exception e){

           s=e.toString();
           return s;

       }
        return "user added";



    }

    private boolean isUsernameUnique(String username) {


            return !isUsernamespresent.contains(username);
    }


    @Override
    public String update(Usermodel model) {
      //  Usermodel user = new Usermodel();
        String k;
        try {





            if (Repository.existsById(model.getId())) {
                if (model.getFullName() != null){
                if (model.getEmail().matches(".*@gmail\\.com")) {
                    if (model.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_\\-+=\\[\\]{}|;:,.<>?]).{8,}$")) {
                        User user = Repository.getById(model.getId());
                        user.setFullName(model.getFullName());
                        user.setEmail(model.getEmail());

                        user.setUserName(model.getUserName());
                        user.setRole(model.getRole());
                        Repository.save(user);
                    }else {
                        throw new WeakPasswordException();
                    }
                    }
                    else {
                        throw new EmailFormateException();

                    }
                }else {
                    throw new NullPointerException();
                }
            }


        }catch (Exception e){
           k=e.toString();

return  k;
        }
      return "data updated";
    }

    @Override
    public User find(Long id) {



                 return Repository.findById(id).orElse(null);


        }
}