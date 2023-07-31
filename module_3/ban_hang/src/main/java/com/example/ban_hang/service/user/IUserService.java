package com.example.ban_hang.service.user;

import com.example.ban_hang.model.user.User;

public interface IUserService {
    User account(String username, String password);
    User checkAccount(String username);
    void signUp(String username, String password, String email);

}
