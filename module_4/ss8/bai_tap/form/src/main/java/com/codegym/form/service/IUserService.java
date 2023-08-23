package com.codegym.form.service;

import com.codegym.form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(String name,Pageable pageable);

    void add(User user);
}
