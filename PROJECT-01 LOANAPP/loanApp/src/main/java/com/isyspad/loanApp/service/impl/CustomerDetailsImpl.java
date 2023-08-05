package com.isyspad.loanApp.service.impl;


import com.isyspad.loanApp.entity.CustomerDetails;
import com.isyspad.loanApp.model.CustomerDetailsReq;
import com.isyspad.loanApp.model.CustomerDetailsResponse;
import com.isyspad.loanApp.repository.CustomerDetailsRepository;
import com.isyspad.loanApp.service.CustomerDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerDetailsImpl implements CustomerDetailsService {
    private int currentId = 1;
    @Autowired
    public CustomerDetailsRepository customerDetailsRepository;

    @Override
    public CustomerDetailsResponse createCustomer(CustomerDetailsReq customerDetails) {
        CustomerDetails customerDtls;

        basicValidation(customerDetails);

        /* ModelMapper modelMapper = new ModelMapper();
        customerDtls = modelMapper.map(customerDetails, CustomerDetails.class);*/

        customerDtls = setCustomerReq(customerDetails);
        String custId = createCustId();
        if (custId!=null){
            customerDtls.setCustId(custId);
        }else
            throw new RuntimeException("CustId is NULL!");

        customerDtls = customerDetailsRepository.save(customerDtls);

        return setCustomerResp(customerDtls);
    }

    public String createCustId(){
        try{
            String maxCustId = customerDetailsRepository.findMaxCustId();
            int currentId;
            if (maxCustId != null) {
                currentId = Integer.parseInt(maxCustId.substring(1)) + 1;
            } else {
                currentId = 1;
            }
            return String.format("%05d", currentId);
        }catch(InputMismatchException | IllegalArgumentException e){
            throw e;
        }

    }

    /*@Override
    public CustomerDetails createCustId(CustomerDetailsReq customerDetails) {
            CustomerDetails resp = new CustomerDetails();
        try {

            // Find the last custId entered the database
            String maxCustId = customerDetailsRepository.findMaxCustId();
            int currentId;
            if (maxCustId != null) {
                currentId = Integer.parseInt(maxCustId.substring(1)) + 1;
            } else {
                currentId = 1;
            }
            String custId = String.format("%05d", currentId);
            customerDetails.setCustId(custId);
//            currentId = currentId + 1;

            resp = customerDetailsRepository.save(setCustomerReq(customerDetails));

            }catch(InputMismatchException | IllegalArgumentException e){
                throw e;
            }
        return resp;


}*/


    // FIND CUSTOMER -- NAVEENKUMAR K
    @Override
    public List<CustomerDetailsResponse> getCustomer(Long ph_num, String cust_Id, Long ph_num2, String name, String father_name) {

        List<CustomerDetails> users = null;

            if (cust_Id != null) {
                users = customerDetailsRepository.findByCustId(cust_Id);
            } else if (ph_num != null) {

                if (!isValidPhNum(ph_num)) {
                    throw new IllegalArgumentException("Invalid Argument or mobile Number");
                }
                users = customerDetailsRepository.findByPhNum(ph_num);
            } else if (ph_num2 != null) {
                if (!isValidPhNum(ph_num2)) {
                    throw new IllegalArgumentException("Invalid Argument or mobile Number");
                }
                users = customerDetailsRepository.findByPhNum2(ph_num2);
            } else if (name != null && father_name != null) {
                users = customerDetailsRepository.findByNameAndFatherName(name, father_name);
            } else if (name != null) {
                users = customerDetailsRepository.findByName(name);
            } else if (father_name != null) {
                users = customerDetailsRepository.findByFatherName(father_name);
            }
        if (users == null) {
            throw new NullPointerException("values cannot be null");
        }


        List<CustomerDetailsResponse> responseList = new ArrayList<>();

        if (users.isEmpty()) {
            throw new InputMismatchException("Invalid input entered");
        } else {
            for (CustomerDetails user : users) {
                CustomerDetailsResponse response = new CustomerDetailsResponse();
                response.setId(user.getId());
                response.setCustId(user.getCustId());
                response.setName(user.getName());
                response.setFatherName(user.getFatherName());
                response.setSpouseName(user.getSpouseName());
                response.setIntoId(user.getIntoId());
                response.setPhNum(user.getPhNum());
                response.setPhNum2(user.getPhNum2());
                response.setAddress(user.getAddress());
                response.setCreatedDate(user.getCreatedDate());
                response.setLastUpdatedDate(user.getLastUpdatedDate());
                response.setCreatedBy(user.getCreatedBy());
                response.setLastUpdatedBy(user.getLastUpdatedBy());
                responseList.add(response);

            }

        }

        return responseList;
    }

    public boolean isValidPhNum(Long num){
        return String.valueOf(num).matches("\\d{10}");
    }


    // UPDATE CUSTOMER -- GOPI VIVEK
    @Override
    public CustomerDetails updateCustomer(String custId, String fieldName, String fieldValue, CustomerDetails customerRequest){
        CustomerDetailsResponse response = new CustomerDetailsResponse();
        CustomerDetails newUpdatedEntity = null;
        try {
            List<CustomerDetails> listEntity = customerDetailsRepository.findByCustId(custId);
            CustomerDetails updateEntity = listEntity.get(0);
            switch (fieldName) {
                case "name":
                    if (fieldValue.matches("^\\d+(\\.\\d+)?$")) {
                        throw new InputMismatchException();
                    } else updateEntity.setName(fieldValue);
                    break;
                case "fatherName":
                    if (fieldValue.matches("^\\d+(\\.\\d+)?$")) {
                        throw new InputMismatchException();
                    } else
                        updateEntity.setFatherName(fieldValue);
                    break;
                case "spouseName":
                    if (fieldValue.matches("^\\d+(\\.\\d+)?$")) {
                        throw new InputMismatchException();
                    } else updateEntity.setSpouseName(fieldValue);
                    break;
                case "address":
                    if (fieldValue.equals(null)) {
                        throw new NullPointerException();
                    } else updateEntity.setAddress(fieldValue);
                    break;
                case "lastUpdatedBy":
                    if (fieldValue.matches("^\\d+(\\.\\d+)?$")) {
                        throw new InputMismatchException();
                    } else updateEntity.setLastUpdatedBy(fieldValue);
                    break;
                case "phNum":
                    if (fieldValue.matches("^[0-9]{10}$")) {
                        updateEntity.setPhNum(Long.valueOf(fieldValue));
                    } else throw new NumberFormatException();
                    break;
                case "phNum2":
                    if (fieldValue.matches("^[0-9]{10}$")) {
                        updateEntity.setPhNum2(Long.valueOf(fieldValue));
                    } else throw new NumberFormatException();
                    break;

                default:
                    throw new IllegalArgumentException();
            }
            newUpdatedEntity = customerDetailsRepository.save(updateEntity);
        } catch (Exception e) {
            throw e;
        }
        return newUpdatedEntity;
    }

    public void basicValidation(CustomerDetailsReq customerDetails){
        //Error handling while entering PhoneNumber
        String l = String.valueOf(customerDetails.getPhNum());
        String p = String.valueOf(customerDetails.getPhNum2());
        if (!l.matches("\\d{10}") || !p.matches("\\d{10}")) {
            throw new IllegalArgumentException();
        }

        if (!customerDetails.getName().matches("[a-zA-Z\\s]+") ||
                !customerDetails.getFatherName().matches("[a-zA-Z\\s]+") ||
                !customerDetails.getSpouseName().matches("[a-zA-Z\\s]+") ||
                !customerDetails.getAddress().matches("[a-zA-Z\\s]+") ||
                !customerDetails.getCreatedBy().matches("[a-zA-Z\\s]+") ||
                !customerDetails.getLastUpdatedBy().matches("[a-zA-Z\\s]+")) {
            throw new InputMismatchException();
        }

    }
    public CustomerDetails setCustomerReq(CustomerDetailsReq custReq){
        CustomerDetails req = new CustomerDetails();

        req.setCustId(custReq.getCustId());
        req.setName(custReq.getName());
        req.setFatherName(custReq.getFatherName());
        req.setSpouseName(custReq.getSpouseName());
        req.setPhNum(custReq.getPhNum());
        req.setPhNum2(custReq.getPhNum2());
        req.setAddress(custReq.getAddress());
        //        req.setCreatedDate(new Date());
        req.setLastUpdatedDate(custReq.getLastUpdatedDate());
        req.setCreatedBy(custReq.getCreatedBy());
        req.setLastUpdatedBy(custReq.getLastUpdatedBy());
        return req;
    }
    public CustomerDetailsResponse setCustomerResp(CustomerDetails custResp){
        CustomerDetailsResponse resp = new CustomerDetailsResponse();

        resp.setCustId(custResp.getCustId());
        resp.setName(custResp.getName());
        resp.setFatherName(custResp.getFatherName());
        resp.setSpouseName(custResp.getSpouseName());
        resp.setPhNum(custResp.getPhNum());
        resp.setPhNum2(custResp.getPhNum2());
        resp.setAddress(custResp.getAddress());
//        req.setCreatedDate(new Date());
        resp.setLastUpdatedDate(custResp.getLastUpdatedDate());
        resp.setCreatedBy(custResp.getCreatedBy());
        resp.setLastUpdatedBy(custResp.getLastUpdatedBy());
        return resp;
    }
}
