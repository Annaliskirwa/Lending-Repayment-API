package com.lendtech.repayment_api.controller;

import com.lendtech.repayment_api.models.body.LoanRepayment;
import com.lendtech.repayment_api.models.database.Loans;
import com.lendtech.repayment_api.models.database.User;
import com.lendtech.repayment_api.services.CreateLoanService;
import com.lendtech.repayment_api.services.CreateUserService;
import com.lendtech.repayment_api.services.LoanRepaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class UserLoansController {

    @Autowired
    CreateUserService createUserService;

    @Autowired
    CreateLoanService createLoanService;

    @Autowired
    LoanRepaymentService loanRepaymentService;

    @PostMapping(value = "/user/create")
    public ResponseEntity userCreation(@RequestBody User user){
        log.info("-----------------------[CREATING USER]---------------------\n{}", user.toString());
        return new ResponseEntity<>(createUserService.createUser(user), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/loan/create/{msisdn}")
    public ResponseEntity loanCreation(@RequestBody Loans loans, @PathVariable String msisdn){
        log.info("-----------------------[CREATING LOAN]---------------------\n{}", loans.toString());
        return new ResponseEntity<>(createLoanService.createLoan(loans, msisdn), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/loan/repayment/{msisdn}")
    public ResponseEntity loanRepayment(@RequestBody LoanRepayment loanRepayment, @PathVariable String msisdn){
        log.info("-----------------------[REPAYING LOAN]---------------------\n{}", loanRepayment.toString());
        return new ResponseEntity<>(loanRepaymentService.repayLoans(loanRepayment, msisdn), new HttpHeaders(), HttpStatus.OK);
    }
}
