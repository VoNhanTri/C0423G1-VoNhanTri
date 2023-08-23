package com.codegym.form.repository;

import com.codegym.form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select *from user where name like :name", nativeQuery = true)
    Page<User> findAll(@Param(value = "name") String name, Pageable pageable);
    Page<User> findUserByNameContaining(String name,Pageable pageable);
    @Modifying
    @Transactional
    @Query(value = "insert into user( name,age,email,number_phone) values(:name,:age,:email,:number_phone)", nativeQuery = true)
    void saveUser(@Param(value = "name") String name,@Param(value = "age") int age,@Param(value = "email") String email,@Param("number_phone") String numberPhone);
}
