package com.lendtech.repayment_api.services;

import com.lendtech.repayment_api.models.database.DefaultLoans;
import com.lendtech.repayment_api.models.database.Loans;
import com.lendtech.repayment_api.repository.DefaultLoanRepository;
import com.lendtech.repayment_api.repository.LoanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SweepLoansService {
    @Autowired
    LoanRepository loanRepository;

    @Autowired
    DefaultLoanRepository defaultLoanRepository;


    @Scheduled(fixedDelayString = "${proc.scheduler}")
    public void sweepDefaultLoans(){
        DefaultLoans defaultLoans = new DefaultLoans();
        try{
            List<Loans> sweep = loanRepository.findAll();
            for(Loans loans:sweep){
                Date updatedDate = loans.getUpdatedDate();
                Date today = new Date();
                LocalDate updated = updatedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate todayDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Period loanTime = Period.between(todayDate, updated);
                int months = loanTime.getMonths();
                if (months >=6 ){
                    defaultLoans.setAmount(loans.getAmount());
                    defaultLoans.setCurrency(loans.getCurrency());
                    defaultLoans.setProductID(loans.getProductID());
                    defaultLoans.setUser(loans.getUser());
                    defaultLoans.setUpdatedDate(loans.getUpdatedDate());
                    defaultLoans.setCreatedDate(loans.getCreatedDate());
                    loanRepository.delete(loans);
                    log.info("-----------------------[DEFAULT LOAN DELETED]---------------------\n{}", loans);
                }
            }
        }catch(Exception e){
            log.info("-----------------------[ERROR]---------------------\n{}", e.getMessage());
        }

    }

}

