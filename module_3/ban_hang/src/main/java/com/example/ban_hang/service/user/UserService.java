package com.example.ban_hang.service.user;

import com.example.ban_hang.model.user.User;
import com.example.ban_hang.repository.user.IUserRepository;
import com.example.ban_hang.repository.user.UserRepository;

public class UserService implements IUserService{
    private static IUserRepository userRepository = new UserRepository();
    @Override
    public User account(String username, String password) {
        return userRepository.account(username,password );
    }


    @Override
    public User checkAccount(String username) {
        return userRepository.checkAccount(username);
    }

    @Override
    public void signUp(String username, String password, String email) {
        userRepository.signUp(username,password,email);
    }


}
