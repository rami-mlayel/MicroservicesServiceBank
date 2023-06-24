package ebank.loanservice.model;


import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "LOAN")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DETAIL", nullable = false, length = 250)
    private String detail;

    @Column(name = "STATUS", nullable = false, length = 250)
    private String status;

    @Column(name = "SUM")
    private BigDecimal sum;

    @Column(name = "MONTH_DURATION")
    private int monthDuration;

}