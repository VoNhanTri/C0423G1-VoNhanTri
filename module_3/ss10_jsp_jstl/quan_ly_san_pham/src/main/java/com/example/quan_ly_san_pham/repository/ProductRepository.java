package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
        private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"banh",15000,"banh chocolate","Orion"));
        productList.add(new Product(2,"keo",10000,"keo chocolate","Orion"));
        productList.add(new Product(3,"snack",5000,"snack chocolate","Orion"));
    }
    public static final String SELECT = "SELECT*FROM product";
    public static final String INSERT = "INSERT INTO product(name,price,status,producer)" + "VALUES (?,?,?,?)";

    @Override
    public List<Product> display() {
        List<Product> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String status = resultSet.getString("status");
                String producer = resultSet.getString("producer");
                list.add(new Product(id, name, price, status, producer));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void add(Product product) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getStatus());
            preparedStatement.setString(4, product.getProducer());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
//        for (int i = 0; i <productList.size() ; i++) {
//            if (productList.get(i).getId()==id){
//                return productList.get(i);
//            }
//        }
        return null;
    }

    @Override
    public void delete(Product product) {
//    productList.remove(product);
    }

    @Override
    public void edit(int id, Product product) {
//        productList.add(id,product);
    }

    @Override
    public Product findName(String name) {
        for (int i = 0; i <productList.size() ; i++) {
            if (productList.get(i).getName().contains(name)){
                return productList.get(i);
            }
        }
        return null;
    }

}
