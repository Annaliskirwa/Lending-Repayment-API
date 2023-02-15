package com.lendtech.repayment_api.services;

import com.lendtech.repayment_api.models.body.LoanRepayment;
import com.lendtech.repayment_api.models.body.LoanWrapper;
import com.lendtech.repayment_api.models.database.Loans;
import com.lendtech.repayment_api.models.database.User;
import com.lendtech.repayment_api.repository.LoanRepository;
import com.lendtech.repayment_api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class LoanRepaymentService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    LoanRepository loanRepository;

    public LoanWrapper repayLoans(LoanRepayment loanRepayment, String msisdn){
        LoanWrapper loanWrapper = new LoanWrapper();
        try{
            User user = userRepository.findUserByMsisdn(msisdn);
            log.info("-----------------------[USER QUERIED]---------------------\n{}", user);
            if(null != user){
                Long userID = user.getUserID();
                log.info("-----------------------[USER ID]---------------------\n{}", userID);
                List<Loans> loan = loanRepository.findByUserID(userID);
                log.info("-----------------------[LOANS LIST]---------------------\n{}", loan);
                if(null != loan){
                    Loans loans = loanRepository.findTopByProductID(loanRepayment.getProductID());
                    log.info("-----------------------[LOANS FROM PRODUCT ID]---------------------\n{}", loans);
                    if(loans != null){
                        String amount = String.valueOf((Integer.parseInt(loans.getAmount()) - Integer.parseInt(loanRepayment.getAmount())));
                        loans.setAmount(amount);
                        loans.setUpdatedDate(new Date());
                        loanRepository.save(loans);
                        loanWrapper.setStatus("0");
                        loanWrapper.setMessage("Loan has been repaid successfully");
                        loanWrapper.setLoan(loans);
                        log.info("-----------------------[LOAN REPAID]---------------------\n{}", loanWrapper);
                        return loanWrapper;
                    }else {
                        loanWrapper.setStatus("2");
                        loanWrapper.setMessage("User does not have the above loan associated with product id");
                        loanWrapper.setLoan(loans);
                        log.info("-----------------------[USER DOESNT HAVE THAT TYPE OF LOAN]---------------------\n{}", loanWrapper);
                        return loanWrapper;
                    }
                }else{
                    loanWrapper.setStatus("2");
                    loanWrapper.setMessage("User does not have a loan");
                    log.info("-----------------------[USER DOESNT HAVE A LOAN]---------------------\n{}", loanWrapper);
                    return loanWrapper;
                }
            }else{
                loanWrapper.setStatus("2");
                loanWrapper.setMessage("User does not exist");
                log.info("-----------------------[USER DOESNT EXIST]---------------------\n{}", loanWrapper);
                return loanWrapper;
            }
        }catch(Exception e){
            loanWrapper.setStatus("1");
            loanWrapper.setMessage("Error");
            log.info("-----------------------[ERROR]---------------------\n{}--{}", loanWrapper, e.getMessage());
            return loanWrapper;
        }
    }
}
