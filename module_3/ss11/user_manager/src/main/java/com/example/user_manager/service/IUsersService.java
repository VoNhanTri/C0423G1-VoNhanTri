package com.example.user_manager.service;

import com.example.user_manager.model.Users;

import java.util.List;

public interface IUsersService {
List<Users> display();
void add(Users users);
List<Users> findById(int id);
void delete(int id);
void edit(Users users);
List<Users> findCountry(String country);
}
