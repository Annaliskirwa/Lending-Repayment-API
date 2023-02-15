package com.lendtech.repayment_api.models.body;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsRequest {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String message;

}
