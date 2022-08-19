//package com.example.controller;
//
//import com.example.entity.BankAccount;
//import com.example.entity.CreditCard;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(maxAge = 3600, origins = "")
//@RequestMapping("/account")
//
//public class BankAccountController {
//
//    @Autowired
//    BankAccountService bankAccountService;
//
//    //VIEW ALL ACCOUNTS
//    @GetMapping("/viewaccounts")
//    public ResponseEntity<List<BankAccount>> viewAllAccounts() {
//        return ResponseEntity.ok(bankAccountService.viewAllAccounts());
//    }
//
//    //VIEW ACCOUNTS BY ID
//    @GetMapping("/findaccountbyid")
//    public ResponseEntity<List<BankAccount>> getAccountById(@RequestParam Integer findId) {
//        return ResponseEntity.ok(bankAccountService.getAccountById(findId));
//    }
//
//    //CREATAE A SAVINGS ACCOUNT
//    @GetMapping("/savingsaccount")
//    public ResponseEntity<BankAccount> addSavingAccount(@RequestParam Integer id) {
//        return ResponseEntity.ok(bankAccountService.addSavingAccount(id));
//    }
//
//    //REQUEST CREDIT CARD
//    @GetMapping("/requestcard")
//    public ResponseEntity<CreditCard> requestCreditCard(@RequestParam Integer id) {
//        return ResponseEntity.ok(bankAccountService.requestCreditCard(id));
//    }
//
//    //WITHDRAW MONEY
//
//
//    //DEPOSITE MONEY
//    @PutMapping("/deposit")
//    @CrossOrigin(origins = "http://localhost:3000")
//    public ResponseEntity<BankAccount> depositMoney(@RequestParam Integer id, @RequestParam double amount, @RequestParam Integer bankId) {
//        return ResponseEntity.ok(bankAccountService.depositMoney(id, amount, bankId));
//    }
//}
//
//
//
//
//
