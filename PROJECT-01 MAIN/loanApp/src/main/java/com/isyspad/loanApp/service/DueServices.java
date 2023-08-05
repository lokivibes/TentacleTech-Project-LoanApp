package com.isyspad.loanApp.service;

import com.isyspad.loanApp.entity.DueCollectioent;
import com.isyspad.loanApp.model.DueModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public interface DueServices {

//    public DueResponse serviceMethod(DueCollectioent dueCollectioent);
    public DueCollectioent serviceMethod(DueCollectioent dueCollectioent);
    List<DueCollectioent> dueFor12Months(DueModel dueModel) throws Exception;

    public DueModel updateTable (DueModel updateduemodel);

    public List<DueCollectioent>findBypaiddate(LocalDate due_paid_date);

    public List<DueCollectioent>bydueStatus(String due_status);
}
