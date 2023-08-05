package com.isyspad.loanApp.service;

import com.isyspad.loanApp.entity.User;
import com.isyspad.loanApp.model.Usermodel;


public interface Userservice {
  public String userdata(Usermodel values);

  //public Findudermodel up(Findudermodel el);
  public String update(Usermodel model);


  public User find(Long id);


}
