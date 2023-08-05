package com.isyspad.loanApp.service.impl;


import com.isyspad.loanApp.entity.DueCollectioent;
import com.isyspad.loanApp.model.DueModel;
import com.isyspad.loanApp.repository.DueRepository;
import com.isyspad.loanApp.service.DueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DueImplentation implements DueServices {
    @Autowired
    DueRepository dueRepository;

    @Override
    public DueCollectioent serviceMethod(DueCollectioent dueCollectioent) {
        dueRepository.save(dueCollectioent);

        return dueCollectioent;
    }

    @Override
    public List<DueCollectioent> dueFor12Months(DueModel dueModel) throws Exception {
try{

        if (dueModel == null || dueModel.getCreated_by() == null ||
                dueModel.getCust_id() == null ||
                dueModel.getLoan_id() == null) {
            throw new NullPointerException();
        }


//      else  if ( StringUtils.isEmpty(dueModel.getCreated_by())||
//              ObjectUtils.isEmpty(dueModel.getCust_id()) ||
//              ObjectUtils.isEmpty(dueModel.getLoan_id())) {
//            throw new IllegalArgumentException();}


        else {
            List<DueCollectioent> dueList = new ArrayList<>();

            LocalDate currentDate = LocalDate.now();
            LocalDate create = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), 1).plusMonths(1);

            Float totalAmount = 20000.0f;
            Float interestRate = 1.5f / 100.0f;//0.015
            Float monthlyInstallment = totalAmount / 12.0f;//1666
            Float remainingAmount = totalAmount;
            Float interestAmount = remainingAmount * interestRate;//20000*0.015=300

            for (int i = 0; i < 12; i++) {

                DueCollectioent dueDetails = new DueCollectioent();

                dueDetails.setCreate_date(currentDate);
                dueDetails.setDue_date(create.plusMonths(i));


                dueDetails.setDue_amount(monthlyInstallment + interestAmount);//1666+300


                dueDetails.setCreated_by(dueModel.getCreated_by());
                dueDetails.setCust_id(dueModel.getCust_id());
                dueDetails.setLoan_id(dueModel.getLoan_id());
                dueList.add(dueDetails);
            }
            return dueRepository.saveAll(dueList);
       }
}catch (Exception e){
    e.printStackTrace();
    throw new Exception(e);
}
    }

    @Override
    public DueModel updateTable(DueModel updateduemodel) {
        try {
            if (updateduemodel == null || updateduemodel.getId() == null) {
                throw new NullPointerException();
            }else {

                DueCollectioent update = dueRepository.getById(updateduemodel.getId());


                update.setDuestatus(updateduemodel.getDuestatus());
                update.setDuepaiddate(updateduemodel.getDuepaiddate());
                update.setDue_paid_amount(updateduemodel.getDue_paid_amount());
                update.setDue_pending_amount(updateduemodel.getDue_pending_amount());
                update.setLast_update_by(updateduemodel.getLast_update_by());
                update.setLast_update_date(updateduemodel.getLast_update_date());

                dueRepository.save(update);
                return updateduemodel;
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }catch (Exception e){
            throw new RuntimeException("Failed to update",e);
        }
    }

    @Override
    public List<DueCollectioent> findBypaiddate(LocalDate due_paid_date) {

    return dueRepository.findByduepaiddate(due_paid_date);

    }

    @Override
    public List<DueCollectioent> bydueStatus(String duestatus) {

            return dueRepository.findByduestatus(duestatus);


    }}