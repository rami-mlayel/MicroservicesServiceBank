package com.example.transactionservice.model;

import com.example.transactionservice.enumeration.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotEmpty
    @Column(name = "ACCOUNT_NUMBER", nullable = false, length = 40, unique = true)
    private String accountNumber;

    @NotNull
    @Column(name = "BALANCE")
    private BigDecimal balance;

    @NotEmpty
    @Column(name = "RIB", nullable = false, length = 40, unique = true)
    private String rib;

    @NotEmpty
    @Email
    @Column(name = "EMAIL", unique = true)
    private String email;

   // @ManyToOne
   // @JoinColumn(name = "idUser", referencedColumnName = "id", updatable=false)
    //private User userAccount;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    //@JsonIgnore
    //@OneToMany(mappedBy = "account")
    //private List<LoanRequest> loanRequestList;
}
