package com.lendtech.repayment_api.models.body;

import com.lendtech.repayment_api.models.database.Loans;
import lombok.Data;

@Data
public class LoanWrapper {
    private String status;
    private String message;
    private Loans loan;
}
