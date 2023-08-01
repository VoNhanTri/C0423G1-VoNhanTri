package com.example.ban_hang.user.service;

import com.example.ban_hang.user.model.User;

public interface IUserService {
    User account(String username, String password);
    User checkAccount(String username);
    void signUp(String username, String password, String email);

}
