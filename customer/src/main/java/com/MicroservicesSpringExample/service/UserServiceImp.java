package com.MicroservicesSpringExample.service;

import com.MicroservicesSpringExample.entity.User;
import com.MicroservicesSpringExample.entity.UserEntityDetails;
import com.MicroservicesSpringExample.exceptions.classExceptions.UserExceptions;
import com.MicroservicesSpringExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    //when I make the interface version of tis it will need to extends from UserDetailedService
    private final UserRepository userRepository;
//    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.bankAccountRepository = bankAccountRepository;
    }

    //TO REGISTER THE USER
    public User registerUser(User user) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        //encode is a build in method
        user.setPassword(encoder.encode(user.getPassword()));
        User userModel = userRepository.save(user);


//        BankAccount bankAccount = new BankAccount();
//        bankAccount.setUser(userModel);
//        bankAccount.setAmount(0.0);
//        bankAccount.setCreatedDate(LocalDate.now());
//        bankAccount.setAccountType(AccountType.CHECKING);
//        bankAccountRepository.save(bankAccount);

        return userModel;
    }

    //TO LOGIN THE USER
//    public User loginUser(String username, String password) {
//        Optional<User> user = userRepository.findByUsername(username);
//        if (user.isPresent()) {
//            if (user.get().getPassword().equals(password)) {
//                return user.get();
//            } else {
//                throw new CredentialsException("INCORRECT CREDENTIAL INFORMATION");
//            }
//        } else {
//            throw new UserExceptions("USER DOESN'T EXIST");
//        }
//    }

    //GET ALL USERS
    public List<User> getAllUsers(){
        return userRepository.findAll();

    }

    //FIND USER BY ID
    public User getUserById(Integer userId){
        Optional<User> foundUser = userRepository.findById(userId);
        if(foundUser.isPresent()){
            return foundUser.get();
        } else {
            throw new UserExceptions("USER DOESN'T EXIST");
        }


    }

    //DELETE A USER BY ID
//    @Transactional
//    public String deleteUser(Integer id, Integer findId){
//        Optional<User> findUser = userRepository.findById(findId);
//        if(findUser.isPresent()) {
//            bankAccountRepository.deleteByUser(findUser.get());
//            userRepository.deleteById(findId);
//            return "User deleed";
//
//        } else {
//            throw new UserExceptions("CAN'T FIND USER TO DELETE");
//        }
//
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).get();
        if(user==null){
//            logger.error("user not found");
            throw new UsernameNotFoundException("Sorry, User Not exist");
        }

        return new UserEntityDetails(user);
    }

    public String getRoleByEmail(String email){
        String role = userRepository.findByEmail(email).get().getRole();
        return role;
    }
}
