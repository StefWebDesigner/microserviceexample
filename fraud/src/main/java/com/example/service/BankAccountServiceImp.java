//package com.example.service;
//
//import com.example.entity.BankAccount;
//import com.example.entity.CreditCard;
//import com.example.entity.CreditCardNumber;
//import com.example.entity.enums.AccountType;
//import com.example.exceptions.classExceptions.UserExceptions;
//import com.example.repository.BankAccountRepository;
//import com.example.repository.CreditCardNumberRepository;
//import com.example.repository.CreditCardRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//@Service
//public class BankAccountServiceImp implements BankAccountService {
//
//    private final BankAccountRepository bankAccountRepository;
//    private final UserRepository userRepository;
//    private final CreditCardRepository creditCardRepository;
//    private final CreditCardNumberRepository creditCardNumberRepository;
//
//    @Autowired
//    public BankAccountServiceImp(BankAccountRepository bankAccountRepository, UserRepository userRepository, CreditCardRepository creditCardRepository, CreditCardNumberRepository creditCardNumberRepository) {
//        this.bankAccountRepository = bankAccountRepository;
//        this.userRepository = userRepository;
//        this.creditCardRepository = creditCardRepository;
//        this.creditCardNumberRepository = creditCardNumberRepository;
//    }
//
//    //VIEW ALL ACCOUNTS
//    public List<BankAccount> viewAllAccounts() {
//        return bankAccountRepository.findAll();
//    }
//
//    //VIEW ACCOUNTS BY ID
//    public List<BankAccount> getAccountById(Integer findId){
//        Optional<User> userModel = userRepository.findById(findId);
//        List<BankAccount> bankaccounts = bankAccountRepository.findAllByUser(userModel.get());
//        return bankaccounts;
//    }
//
//
//    //DEPOIST MONEY
//    public BankAccount depositMoney(Integer id, double amount, Integer bankId){
//        Optional<User> userModel = userRepository.findById(id);
//        if(userModel.isPresent()){
//            BankAccount bankAccountModel = bankAccountRepository.findById(bankId).get();
//            double currentAmount = bankAccountModel.getAmount();
//            double updatedAmount = currentAmount + amount;
//            bankAccountModel.setAmount(updatedAmount);
//            return bankAccountRepository.save(bankAccountModel);
//        } else {
//            throw new UserExceptions("USER DOESN'T EXIST");
//        }
//
//    }
//
//    public String getRandomNumbers(){
//
//        String chars = "0123456789";
//
//        Random rnd = new Random();
//        StringBuilder sb = new StringBuilder(16);
//        for (int i = 0; i < 16; i++)
//            sb.append(chars.charAt(rnd.nextInt(chars.length())));
//        return sb.toString();
//
//    }
//
//    //REQUEST CREDTIC ARD
//    public CreditCard requestCreditCard(Integer id) {
//        Optional<User> userModel = userRepository.findById(id);
//        if (userModel.isPresent()) {
//
//            CreditCardNumber creditCardNumberModel = new CreditCardNumber();
//            creditCardNumberModel.setNumber(getRandomNumbers());
//
//            creditCardNumberRepository.save(creditCardNumberModel);
//
//            CreditCard creditCard =  new CreditCard();
//            creditCard.setCrediCardNumber(creditCardNumberModel);
//
//
//            BankAccount bankAccount = bankAccountRepository.findAllByUser(userModel.get()).stream().findFirst().get();
//
//            creditCard.setBankAccount(bankAccount);
//
//            creditCard.setCreditLimit(3000.0);
//
//            creditCardRepository.save(creditCard);
//
//            return creditCard;
//
//        } else {
//            throw new UserExceptions("User Not Logged In");
//
//        }
//
//    }
//
//    //ADD SAVING ACCOUNT
//    public BankAccount addSavingAccount(Integer id){
//        Optional <User> userModel = userRepository.findById(id);
//        if(userModel.isPresent()) {
//            BankAccount bankAccount = new BankAccount();
//            bankAccount.setAccountType(AccountType.SAVING);
//            bankAccount.setUser(userModel.get());
//            bankAccount.setAmount(0.0);
//            bankAccount.setCreatedDate(LocalDate.now());
//            return bankAccountRepository.save(bankAccount);
////                    bankAccountModel.setAccountType(AccountType.SAVING);
////                return bankAccountModel;
//
//
//        } else {
//            throw new UserExceptions("User Not Logged In");
//
//        }
//    }
//
//
//
//
//}
