package com.example.user_manager.repository;

import com.example.user_manager.model.Users;

import java.util.List;

public interface IUserRepository {
   void insertUser(Users users);
   List<Users> selectUser(int id);
   List<Users> selectAllUsers();
   boolean deleteUsers(int id);
   boolean updateUsers(Users users);
   List<Users> findCountry(String country);
}
