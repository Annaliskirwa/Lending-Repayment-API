package com.lendtech.repayment_api.configs.sms;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfiguration {
    private String accountSid;
    private String authtoken;
    private String trialNumber;
}
