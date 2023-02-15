package com.lendtech.repayment_api.repository;

import com.lendtech.repayment_api.models.database.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loans, Long> {
    @Query(value = "SELECT * FROM lendtech_loans l WHERE l.userid LIKE %?1%", nativeQuery = true)
    List<Loans> findByUserID(Long userid);

    Loans findLoansByProductID(String productID);

    Loans findTopByProductID(String productID);
}
