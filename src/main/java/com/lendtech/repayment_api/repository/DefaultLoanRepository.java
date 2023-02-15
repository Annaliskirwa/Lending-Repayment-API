package com.lendtech.repayment_api.repository;

import com.lendtech.repayment_api.models.database.DefaultLoans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultLoanRepository extends JpaRepository<DefaultLoans, Long> {
}
