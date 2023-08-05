package com.isyspad.loanApp.controller;


import com.isyspad.loanApp.entity.DueCollectioent;
import com.isyspad.loanApp.model.DueModel;
import com.isyspad.loanApp.service.DueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DueController {
    @Autowired
    DueServices dueServices;

//M kabelan -creation
    @PostMapping(path="/DueCreation")
    public ResponseEntity<DueCollectioent>finalSave(@RequestBody DueModel dueModel) throws Exception {
        List<DueCollectioent> controlResult = dueServices.dueFor12Months(dueModel);
        DueCollectioent controlRespo= dueServices.serviceMethod(controlResult.get(1));

        return new ResponseEntity<>(controlRespo, HttpStatus.CREATED);

    }
    //saran -update
   @PutMapping(path = "updated")
   public ResponseEntity<DueModel> updatedues (@RequestBody DueModel dueModel){
        DueModel ref = dueServices.updateTable(dueModel);
        return new ResponseEntity<>(ref,HttpStatus.CREATED);
   }


//Indhira - Find
    @GetMapping("search")
    public ResponseEntity<List<DueCollectioent>> getbydate(@RequestBody DueCollectioent dueCollectioent) {
        LocalDate bydate = dueCollectioent.getDuepaiddate();
       String usingStatus = dueCollectioent.getDuestatus();

        List<DueCollectioent>  getDate = dueServices.findBypaiddate(bydate);
       List<DueCollectioent> forstatus = dueServices.bydueStatus(usingStatus);

        List<DueCollectioent> total = new ArrayList<>();
        total.addAll(getDate);
        total.addAll(forstatus);



        return ResponseEntity.ok(total);

}}
