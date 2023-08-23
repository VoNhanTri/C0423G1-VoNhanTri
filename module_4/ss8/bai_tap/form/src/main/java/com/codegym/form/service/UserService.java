package com.codegym.form.service;

import com.codegym.form.model.User;
import com.codegym.form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public Page<User> findAll(String name,Pageable pageable) {
        return iUserRepository.findUserByNameContaining(name,pageable);
    }

    @Override
    public void add(User user) {
        iUserRepository.saveUser(user.getName(), user.getAge(), user.getEmail(), user.getNumberPhone());
    }
}
