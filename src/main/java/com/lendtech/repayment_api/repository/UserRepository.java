package com.lendtech.repayment_api.repository;

import com.lendtech.repayment_api.models.database.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByMsisdn(@Size(max = 16) @NotNull String msisdn);
}
