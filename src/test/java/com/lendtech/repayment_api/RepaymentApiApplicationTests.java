package com.lendtech.repayment_api;

import com.lendtech.repayment_api.models.database.User;
import com.lendtech.repayment_api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
//@RunWith(SpringRunner.class)
//@DataJpaTest
class RepaymentApiApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
    }

}
