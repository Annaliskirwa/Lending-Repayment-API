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
@Table(name = "LENDTECH_USERS")
public class User {

    @Id
    @Column
    private Long id;

    @Size(max = 16)
    @NotNull
    @Column(name = "MSISDN", nullable = false)
    private String msisdn;

    @Size(max = 50)
    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Size(max = 50)
    @NotNull
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Size(max = 10)
    @NotNull
    @Column(name = "GENDER", nullable = false)
    private String gender;
}
