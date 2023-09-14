package com.isyspad.loanApp.service;

import com.isyspad.loanApp.entity.ShareHolderDetails;
import com.isyspad.loanApp.model.ShareHolderDetailsResponse;
import com.isyspad.loanApp.model.ShareHolderReq;

import java.util.List;

public interface ShareHolderService {

    ShareHolderDetailsResponse createShareHolder(ShareHolderReq shareHolderReq);

//    String generateNewShareholderUserId();

//    ShareHolderDetailsResponse createShareHolder(ShareHolderReq shareHolderReq);

    public List<ShareHolderDetails> findbyuserid(String userid);
    public List<ShareHolderDetails> findbyShareHolderName(String shareHolderName);
    public List<ShareHolderDetails> findbyFatherName(String fatherName);

    ShareHolderDetailsResponse updateShareHolder(ShareHolderReq shareHolderReq);

//    ShareHolderDetails setShareReq(ShareHolderReq shareReq);
//
//    ShareHolderDetailsResponse setShareResp(ShareHolderDetails shareResp);
}
