package com.lendtech.repayment_api.models.database;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "LENDTECH_LOANS")
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long loanID;

    @Size(max = 50)
    @NotNull
    @Column(name = "AMOUNT", nullable = false)
    private String amount;

    @Size(max = 10)
    @NotNull
    @Column(name = "CURRENCY", nullable = false)
    private String currency;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Column(name = "PRODUCT_ID")
    private String productID;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
