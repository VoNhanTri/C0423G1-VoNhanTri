package com.example.ban_hang.repository.user;

import com.example.ban_hang.model.user.User;
import com.example.ban_hang.repository.Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository{
    private static final String ACCOUNT = " select*from accounts where account_username =? and account_password=? ; ";
    private static final String SIGNUP = " insert into accounts(account_username,account_password,account_email,role_id)values(?,?,?,3) ";
    private static final String CHECK = " select*from accounts where account_username=?; ";
    @Override
    public User account(String username, String password) {
        User user = null;
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ACCOUNT);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String newUser = resultSet.getString("account_username");
                String newPass = resultSet.getString("account_password");
                user = new User(newUser,newPass);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    public User checkAccount(String username){
            User user =null;
            Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String newUser = resultSet.getString("account_username");
                String newPass = resultSet.getString("account_password");
                String newEmail = resultSet.getString("account_email");
                user = new User(newUser,newPass,newEmail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void signUp(String username, String password, String email) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SIGNUP);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
