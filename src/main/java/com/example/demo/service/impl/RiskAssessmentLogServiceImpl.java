package com.example.demo.service.impl;
import com.example.demo.model.RiskAssessmentLog;
import com.example.demorepository.RislAssessmentLogRespository;
import com.example.demo.service.RiskAssessmentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sterotype.Service;

import java.util.List;

@Service
public class RiskAssessmentLogServiceImpl implements RiskAssessmentLogService{
    @Autowired
    RiskAssessmentLogRepository repo;

    public List<RiskAssessmentLog>getLogsByRequest(Long loanRequestID){
        return repo.findByRequestd(loanRequestId);
    }
}