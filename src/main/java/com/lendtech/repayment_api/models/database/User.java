package com.lendtech.repayment_api.models.database;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "LENDTECH_USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long userID;

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

    public User() {

    }
}
