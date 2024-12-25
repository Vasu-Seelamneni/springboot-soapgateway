package com.sws.springbootsoapgateway.entity;

import com.sws.springbootsoapgateway.constants.AccountType;
import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Account number cannot be blank")
    private String accountNumber;

    @NotBlank(message = "Account holder name cannot be blank")
    private String accountHolderName;

    @NotBlank(message = "Balance cannot be blank")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Account type cannot be blank")
    private AccountType type;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Account number cannot be blank") String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(@NotBlank(message = "Account number cannot be blank") String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public @NotBlank(message = "Account holder name cannot be blank") String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(@NotBlank(message = "Account holder name cannot be blank") String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public @NotBlank(message = "Balance cannot be blank") BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(@NotBlank(message = "Balance cannot be blank") BigDecimal balance) {
        this.balance = balance;
    }

    public @NotBlank(message = "Account type cannot be blank") AccountType getType() {
        return type;
    }

    public void setType(@NotBlank(message = "Account type cannot be blank") AccountType type) {
        this.type = type;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
