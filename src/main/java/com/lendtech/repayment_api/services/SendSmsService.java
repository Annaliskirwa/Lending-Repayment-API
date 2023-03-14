package com.lendtech.repayment_api.services;


import com.lendtech.repayment_api.configs.sms.TwilioConfiguration;
import com.lendtech.repayment_api.models.body.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
@Slf4j
public class SendSmsService{
    @Autowired
    TwilioConfiguration twilioConfiguration;

    public void sendSms(SmsRequest smsRequest) {
        try{

            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);

            creator.create();

            log.info("-----------------------[SMS SENT SUCCESSFULLY]---------------------\n");
        }catch(Exception e){
            log.info("-----------------------[ERROR:SMS COULD NOT BE SENT]---------------------\n{}", e.getMessage());
        }
    }
}
