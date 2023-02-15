package com.lendtech.repayment_api.models.body;

import com.lendtech.repayment_api.models.database.User;
import lombok.Data;

@Data
public class UserWrapper {
    private String status;
    private String message;
    private User user;
}
