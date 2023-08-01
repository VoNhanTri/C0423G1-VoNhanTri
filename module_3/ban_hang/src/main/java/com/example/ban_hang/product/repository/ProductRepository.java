package com.example.ban_hang.product.repository;

import com.example.ban_hang.product.model.Product;
import com.example.ban_hang.Base;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String ADD = " insert into items (item_code,item_name,item_price,item_inventory,item_description,item_type_id)" +
            "values(?, ?, ?, ?, ?, ?); ";
    private static final  String FIND_BY_ID = " select item_id , item_code,item_name ,item_price ,item_inventory,item_available, item_type_id from items where id =? ; ";
    private static final  String DISPLAY = " select*from item_images im join items it on im.item_id = it.item_id join item_types ite on it.item_type_id = ite.item_type_id ; ";
    private static final String DELETE = " delete from items where id = ? ";
    private static final String EDIT = " update items set item_code=?,item_name=?,item_price=?,item_inventory=?,item_description=? where id =?";
    private static final String FIND_NAME = " select*from items where item_name like ? ";
    @Override
    public void add(Product product) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);
            preparedStatement.setString(1, product.getCode());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3,product.getPrice());
            preparedStatement.setInt(4,product.getInventory());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getProductType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Product findById(int id) {
        Product product = null;
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String code = resultSet.getString("item_code");
                String name = resultSet.getString("item_name");
                int price = resultSet.getInt("item_price");
                int inventory = resultSet.getInt("item_inventory");
                String description = resultSet.getString("item_description");
                int productType = resultSet.getInt("item_type_id");
                product = new Product(code,name,price,inventory,description,productType);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> display() {
        List<Product> products = new ArrayList<>();
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DISPLAY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String code = resultSet.getString("item_code");
                String name = resultSet.getString("item_name");
                String image = resultSet.getString("image_url");
                int price = resultSet.getInt("item_price");
                int inventory = resultSet.getInt("item_inventory");
                String description = resultSet.getString("item_description");
                int productType = resultSet.getInt("item_type_id");
                products.add(new Product(code,name,image,price,inventory,description,productType));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void edit(int id, Product product) {

    }

    @Override
    public List<Product> findName(String name) {
        return null;
    }


}

