package com.lendtech.repayment_api.services;

import com.lendtech.repayment_api.models.body.LoanWrapper;
import com.lendtech.repayment_api.models.database.Loans;
import com.lendtech.repayment_api.models.database.User;
import com.lendtech.repayment_api.repository.LoanRepository;
import com.lendtech.repayment_api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class CreateLoanService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    LoanRepository loanRepository;

    public LoanWrapper createLoan(Loans loans, String msisdn){
        LoanWrapper loanWrapper = new LoanWrapper();
        try{
            User user = userRepository.findUserByMsisdn(msisdn);
            if(null != user){
                loans.setUser(user);
                loans.setCreatedDate(new Date());
                loans.setUpdatedDate(new Date());
                loanRepository.save(loans);
                loanWrapper.setStatus("0");
                loanWrapper.setMessage("Loan created successfully");
                loanWrapper.setLoan(loans);
                return loanWrapper;
            }else{
                loanWrapper.setStatus("2");
                loanWrapper.setMessage("User does not exist");
                return loanWrapper;
            }
        }catch(Exception e){
            loanWrapper.setMessage("error");
            loanWrapper.setStatus("1");
            log.info("-----------------------[ERROR]---------------------\n{} {}", loanWrapper, e.getMessage());
            return loanWrapper;
        }
    }
}
