package com.example.ban_hang.repository.user;

import com.example.ban_hang.model.user.User;

public interface IUserRepository {
    User account(String username, String password);

    User checkAccount(String username);
    void signUp(String username, String password, String email);
}
