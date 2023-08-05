package com.isyspad.loanApp.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Usermodel {

    private Long id;
    private String fullName;

    private String userName;

    private String password;

    private String email;


    private Date lastUpdated;

    private Long createdBy;
    private Long updatedBy;


    private Date createdDate;
    private String role;
    private String security1;
    private String answer1;
    private String security2;
    private  String answer2;


    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getSecurity2() {
        return security2;
    }

    public void setSecurity2(String security2) {
        this.security2 = security2;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }



    public String getSecurity1() {
        return security1;
    }

    public void setSecurity1(String security1) {
        this.security1 = security1;
    }


//    public  Usermodel(long id, String fullName, String userName, String role, String password, String email,
//                      Date createdDate, Date lastUpdated, long createdBy, long updatedBy, String security1,
//                      String answer1, String security2 , String answer2){
//        this.id=id;
//        this.fullName=fullName;
//        this.userName=userName;
//        this.role=role;
//        this.password=password;
//        this.email=email;
//        this.createdDate=createdDate;
//        this.lastUpdated=lastUpdated;
//        this.createdBy=createdBy;
//        this.updatedBy=updatedBy;
//        this.security1=security1;
//        this.answer1=answer1;
//        this.security2=security2;
//        this.answer2=answer2;
//
//    }
//
    public Long getId() {
     return id;
 }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



}
