//package com.example.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "debit_card_model")
//public class DebitCard {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer debitId;
//    private Long debitCardNumber;
//
//    @ManyToOne
//    BankAccount bankAccount;
//
//    public Integer getDebitId() {
//        return debitId;
//    }
//
//    public void setDebitId(Integer debitId) {
//        this.debitId = debitId;
//    }
//
//    public Long getDebitCardNumber() {
//        return debitCardNumber;
//    }
//
//    public void setDebitCardNumber(Long debitCardNumber) {
//        this.debitCardNumber = debitCardNumber;
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