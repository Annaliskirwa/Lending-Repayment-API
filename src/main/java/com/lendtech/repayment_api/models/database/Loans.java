package com.lendtech.repayment_api.models.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "LENDTECH_LOANS")
public class Loans {
    @Id
    @Column
    private String id;

    @Size(max = 50)
    @NotNull
    @Column(name = "AMOUNT", nullable = false, length = 50)
    private String amount;

    @Size(max = 10)
    @NotNull
    @Column(name = "CURRENCY", nullable = false, length = 10)
    private String currency;

    @Column(name = "CREATED_DATE")
    private String createdDate;

    @Column(name = "UPDATED_DATE")
    private String updatedDate;
}
