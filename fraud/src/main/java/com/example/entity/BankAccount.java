//package com.example.entity;
//
//import com.example.entity.enums.AccountType;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "bank_account_model")
//public class BankAccount {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
////    @Column
//    private Integer accountId;
//    //    @Column
//    private LocalDate createdDate;
//    @Column
//    private Double amount;
//    @Column
//    @Enumerated(value = EnumType.STRING)
//    private AccountType accountType;
//
//    @ManyToOne
//    User user;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public AccountType getAccountType() {
//        return accountType;
//    }
//
//    public void setAccountType(AccountType accountType) {
//        this.accountType = accountType;
//    }
//    public Integer getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(Integer accountId) {
//        this.accountId = accountId;
//    }
//
//    public LocalDate getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDate createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Double amount) {
//        this.amount = amount;
//    }
//}
