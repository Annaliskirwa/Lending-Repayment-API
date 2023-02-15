package com.lendtech.repayment_api.services;

import com.lendtech.repayment_api.models.body.UserWrapper;
import com.lendtech.repayment_api.models.database.User;
import com.lendtech.repayment_api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateUserService {
    @Autowired
    UserRepository userRepository;

    public UserWrapper createUser(User user){
        UserWrapper userWrapper = new UserWrapper();
        try{
            String userExists = userRepository.findUserByMsisdn(user.getMsisdn()) == null ? null : "true";
            if(userExists == "true"){
                userWrapper.setMessage("user exists in the database");
                userWrapper.setStatus("2");
                log.info("-----------------------[USER EXISTS]---------------------\n{}", userWrapper);
                return userWrapper;
            }
            else{
                userRepository.save(user);
                userWrapper.setMessage("user created successfuly");
                userWrapper.setStatus("0");
                userWrapper.setUser(user);
                log.info("-----------------------[USER CREATED]---------------------\n{}", userWrapper);
                return userWrapper;
            }
        }catch (Exception e){
            userWrapper.setMessage("error");
            userWrapper.setStatus("1");
            log.info("-----------------------[ERROR]---------------------\n{} {}", userWrapper, e.getMessage());
            return userWrapper;
        }
    }
}
