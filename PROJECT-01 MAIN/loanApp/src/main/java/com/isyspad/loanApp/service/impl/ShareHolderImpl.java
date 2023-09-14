package com.isyspad.loanApp.service.impl;

import com.isyspad.loanApp.entity.ShareHolderDetails;
import com.isyspad.loanApp.model.ShareHolderDetailsResponse;
import com.isyspad.loanApp.model.ShareHolderReq;
import com.isyspad.loanApp.repository.ShareHolderRepository;
import com.isyspad.loanApp.service.ShareHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;

@Service
public class ShareHolderImpl implements ShareHolderService {

    @Autowired
    public ShareHolderRepository shareHolderRepository;

    @Override
    public ShareHolderDetailsResponse createShareHolder(ShareHolderReq shareHolderReq) {

        ShareHolderDetails shareHolderDetails;

        basicValidation(shareHolderReq);
        shareHolderDetails = setShareReq(shareHolderReq);

        String newUserId = generateNewShareholderUserId();
        shareHolderDetails.setUserid(newUserId);


        shareHolderDetails  = shareHolderRepository.save(shareHolderDetails);

        return setShareResp(shareHolderDetails);

    }
    public String generateNewShareholderUserId() {
        ShareHolderDetails latestShareHolder = shareHolderRepository.findTopByOrderByIdDesc();
        int newUserIdNumber;
        if (latestShareHolder == null) {

            newUserIdNumber = 1;
        } else {
            String lastId = latestShareHolder.getUserid();
            newUserIdNumber = Integer.parseInt(lastId.substring(2)) + 1;
        }
        return "SA" + String.format("%03d", newUserIdNumber);
    }


    //    Find
    @Override
    public List<ShareHolderDetails> findbyuserid(String userid) {
        return shareHolderRepository.searchByUserid(userid);
    }
    public List<ShareHolderDetails> findbyShareHolderName(String shareHolderName){
        return shareHolderRepository.searchByShareHolderName(shareHolderName);
    }
    public List<ShareHolderDetails> findbyFatherName(String fatherName){
        return shareHolderRepository.searchByFatherName(fatherName);
    }


    //    Update
    @Override
    public ShareHolderDetailsResponse updateShareHolder(ShareHolderReq shareHolderReq) {


        ShareHolderDetails update=shareHolderRepository.getById(shareHolderReq.getId());

        update.setShareHolderName(shareHolderReq.getShareHolderName());
        update.setFatherName(shareHolderReq.getFatherName());
        update.setSpouseName(shareHolderReq.getSpouseName());
        update.setAddress(shareHolderReq.getAddress());
        update.setPhNum1(shareHolderReq.getPhNum1());
        update.setPhNum2(shareHolderReq.getPhNum2());
        update.setInvestedAmount(shareHolderReq.getInvestedAmount());

        ShareHolderDetails updatedShareHolder = shareHolderRepository.save(update);

        return setShareResp(updatedShareHolder);
    }

    private void basicValidation(ShareHolderReq shareHolderReq) {

        String PhNum1 = String.valueOf(shareHolderReq.getPhNum1());
        String PhNum2= String.valueOf(shareHolderReq.getPhNum2());
        if (!PhNum1.matches( "\\d{10}") || !PhNum2.matches("\\d{10}")) {
            throw new IllegalArgumentException();
        }

        if (!shareHolderReq.getShareHolderName().matches("[a-zA-Z\\s]+") ||
                !shareHolderReq.getFatherName().matches("[a-zA-Z\\s]+") ||
                !shareHolderReq.getSpouseName().matches("[a-zA-Z\\s]+") ||
                !shareHolderReq.getAddress().matches("[a-zA-Z\\s]+")){
            throw new InputMismatchException();
        }


    }


    public ShareHolderDetails setShareReq(ShareHolderReq shareReq){
        ShareHolderDetails req = new ShareHolderDetails();

        req.setUserid(shareReq.getUserid());
        req.setShareHolderName(shareReq.getShareHolderName());
        req.setFatherName(shareReq.getFatherName());
        req.setSpouseName(shareReq.getSpouseName());
        req.setAddress(shareReq.getAddress());
        req.setPhNum1(shareReq.getPhNum1());
        req.setPhNum2(shareReq.getPhNum2());
        req.setInvestedAmount(shareReq.getInvestedAmount());

        return req;
    }

    public ShareHolderDetailsResponse setShareResp(ShareHolderDetails shareResp){
        ShareHolderDetailsResponse resp = new ShareHolderDetailsResponse();
        resp.setId(shareResp.getId());
        resp.setUserid(shareResp.getUserid());
        resp.setShareHolderName(shareResp.getShareHolderName());
        resp.setFatherName(shareResp.getFatherName());
        resp.setSpouseName(shareResp.getSpouseName());
        resp.setAddress(shareResp.getAddress());
        resp.setPhNum1(shareResp.getPhNum1());
        resp.setPhNum2(shareResp.getPhNum2());
        resp.setInvestedAmount(shareResp.getInvestedAmount());
        resp.setCreatedDate(shareResp.getCreatedDate());

        return resp;
    }
}
