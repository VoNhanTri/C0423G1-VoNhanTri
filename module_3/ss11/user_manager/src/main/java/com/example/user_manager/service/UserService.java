package com.example.user_manager.service;

import com.example.user_manager.model.Users;
import com.example.user_manager.repository.IUserRepository;
import com.example.user_manager.repository.UserRepository;

import java.util.List;

public class UserService implements IUsersService {
    private static IUserRepository userRepository = new UserRepository();

    @Override
    public List<Users> display() {
        return userRepository.selectAllUsers();
    }

    @Override
    public void add(Users users) {
        userRepository.insertUser(users);
    }

    @Override
    public List<Users> findById(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteUsers(id);

    }

    @Override
    public void edit(Users users) {
userRepository.updateUsers(users);
    }

    @Override
    public List<Users> findCountry(String country) {
        return userRepository.findCountry(country);
    }
}
