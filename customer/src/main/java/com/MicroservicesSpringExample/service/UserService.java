package com.MicroservicesSpringExample.service;

import com.MicroservicesSpringExample.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {

    public User registerUser(User user);
    public List<User> getAllUsers();
    public User getUserById(Integer userId);
//    public String deleteUser(Integer id, Integer findId);
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    public String getRoleByEmail(String email);


}
