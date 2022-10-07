package com.example.lab55.service;

import com.example.lab55.dao.UserDao;
import com.example.lab55.entity.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {


    private final UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> maybeUser = userDao.findByUsername(username);
        if(maybeUser.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        return (UserDetails)maybeUser.get();
    }


    public List<User> getUsers(){
        return userDao.getAllUsers();
    }


}
