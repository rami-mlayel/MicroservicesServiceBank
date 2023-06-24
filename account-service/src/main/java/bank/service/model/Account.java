package bank.service.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
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

    @NotEmpty
    @Column(name = "userAccount", nullable = false)
    private Long userAccount;

    @Enumerated(EnumType.STRING)
    private AccountType type;
}