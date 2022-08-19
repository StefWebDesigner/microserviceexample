//package com.example.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "credit_card_model")
//public class CreditCard {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer creditId;
//    @Column
//    private Double creditLimit;
//    @OneToOne
//    private CreditCardNumber crediCardNumber;
//
//    @ManyToOne
//    BankAccount bankAccount;
//
//    public Integer getCreditId() {
//        return creditId;
//    }
//
//    public void setCreditId(Integer creditId) {
//        this.creditId = creditId;
//    }
//
//    public Double getCreditLimit() {
//        return creditLimit;
//    }
//
//    public void setCreditLimit(Double creditLimit) {
//        this.creditLimit = creditLimit;
//    }
//
//    public CreditCardNumber getCrediCardNumber() {
//        return crediCardNumber;
//    }
//
//    public void setCrediCardNumber(CreditCardNumber crediCardNumber) {
//        this.crediCardNumber = crediCardNumber;
//    }
//
//    public BankAccount getBankAccount() {
//        return bankAccount;
//    }
//
//    public void setBankAccount(BankAccount bankAccount) {
//        this.bankAccount = bankAccount;
//    }
//}
