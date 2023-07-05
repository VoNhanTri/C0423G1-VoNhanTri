package com.example.user_manager.repository;

import com.example.user_manager.model.Users;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String INSERT = "INSERT INTO  users(name,email,country)VALUES(?,?,?);";
    private static final String SELECT_BY_ID = "select id,name,email,country from users where id=?;";
    private static final String SELECT_ALL = "select*from users";
    private static final String DELETE = "delete from users where id=?";
    private static final String UPDATE = " update users set name=?,email=?,country=? where id=? ";
    private static final String SELECT_COUNTRY = " select*from users where country like ? ; ";
    private static final String CALL_SELECT_ALL = " call select_all()";
    private static final String CALL_INSERT = " call insert_data(?,?,?) ";
    private static final String CALL_DELETE = " call delete_data(?) ";
    private static final String CALL_EDIT = " call edit_data(?,?,?,?); ";

    @Override
    public void insertUser(Users users) {
        Connection connection = Base.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(CALL_INSERT);
            callableStatement.setString(1, users.getName());
            callableStatement.setString(2, users.getEmail());
            callableStatement.setString(3, users.getCountry());
            callableStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Users selectUser(int id) {
        Users users = null;
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users = new Users(id, name, email, country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<Users> selectAllUsers() {
        List<Users> users = new ArrayList<>();
        Connection connection = Base.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(CALL_SELECT_ALL);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new Users(id, name, email, country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void deleteUsers(int id) {
        Connection connection = Base.getConnection();

        try {
            CallableStatement callableStatement = connection.prepareCall(CALL_DELETE);
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateUsers(int id, Users users) {
        Connection connection = Base.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(CALL_EDIT);
            callableStatement.setInt(1, id);
            callableStatement.setString(2, users.getName());
            callableStatement.setString(3, users.getEmail());
            callableStatement.setString(4, users.getCountry());
            callableStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Users> findCountry(String country) {
        List<Users> users = new ArrayList<>();
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNTRY);
            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                users.add(new Users(name, email, country));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
