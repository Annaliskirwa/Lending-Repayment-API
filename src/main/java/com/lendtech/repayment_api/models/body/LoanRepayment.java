package com.lendtech.repayment_api.models.body;

import lombok.Data;

@Data
public class LoanRepayment {
    private String productID;
    private String amount;
}
