package com.isyspad.loanApp.controller;

import com.isyspad.loanApp.entity.ShareHolderDetails;
import com.isyspad.loanApp.model.ShareHolderDetailsResponse;
import com.isyspad.loanApp.model.ShareHolderReq;
import com.isyspad.loanApp.service.ShareHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shareholder")
public class ShareHolderController {

    @Autowired
    private ShareHolderService shareHolderService;


    @Autowired
    public ShareHolderController(ShareHolderService shareHolderService) {
        this.shareHolderService = shareHolderService;
    }

    @PostMapping("/sharecreate")
    public ResponseEntity<ShareHolderDetailsResponse> createShareHolder(@RequestBody ShareHolderReq shareHolderReq) {
        ShareHolderDetailsResponse responsecontroller=shareHolderService.createShareHolder(shareHolderReq);

        return new ResponseEntity<>(responsecontroller, HttpStatus.CREATED);
    }

    @GetMapping("/sharefind")
    public ResponseEntity<List<ShareHolderDetails>> getuser(@RequestBody ShareHolderDetails shareHolderDetails) {

        String byId = shareHolderDetails.getUserid();
        String byName=shareHolderDetails.getShareHolderName();
        String byFatherName=shareHolderDetails.getFatherName();
        List<ShareHolderDetails> fetchID = shareHolderService.findbyuserid(byId);
        List<ShareHolderDetails> fetchname=shareHolderService.findbyShareHolderName(byName);
        List<ShareHolderDetails> fetchfatherName=shareHolderService.findbyFatherName(byFatherName);

        List<ShareHolderDetails> matchingDetails = new ArrayList<>();
        matchingDetails.addAll(fetchID);
        matchingDetails.addAll(fetchname);
        matchingDetails.addAll(fetchfatherName);

        return ResponseEntity.ok(matchingDetails);
    }

    @PutMapping("/shareupdate")
    public ResponseEntity<ShareHolderDetailsResponse> updateShareHolder (@RequestBody ShareHolderReq shareHolderReq){
        ShareHolderDetailsResponse updatedShareHolder = shareHolderService.updateShareHolder(shareHolderReq);
        return new ResponseEntity<>(updatedShareHolder, HttpStatus.OK);
    }
}
