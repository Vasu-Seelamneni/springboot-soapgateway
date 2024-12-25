package com.sws.springbootsoapgateway.entity;

import com.sws.springbootsoapgateway.constants.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @NotBlank(message = "Amount cannot be blank")
    private Account account;

    @NotBlank(message = "Amount cannot be blank")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Account type cannot be blank")
    private TransactionType type;

    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank(message = "Transaction date cannot be blank")
    private Date transactionDate;

    @Size(max = 255, message = "Description cannot be longer than 255 characters")
    private String description;


}
