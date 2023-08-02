package com.example.ban_hang.product.repository;

import com.example.ban_hang.Base;
import com.example.ban_hang.product.dto.ProductListDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    @Override
    public List<ProductListDto> getAllDto() {
        List<ProductListDto> productListDto = new ArrayList<>();
        try {
            Statement statement = Base.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(" select*from item_images im\n" +
                    "            join items it on im.item_id = it.item_id \n" +
                    "            join item_types ite on it.item_type_id = ite.item_type_id ; ");
            ProductListDto productList;
            while (resultSet.next()){
                productList = new ProductListDto();
                productList.setId(resultSet.getInt("item_id"));
                productList.setCode(resultSet.getString("item_code"));
                productList.setName(resultSet.getString("item_name"));
                productList.setPrice(resultSet.getInt("item_price"));
                productList.setInventory(resultSet.getInt("item_inventory"));
                productList.setDescription(resultSet.getString("item_description"));
                productList.setNameType(resultSet.getString("item_type_name"));
                productList.setUrlImage(resultSet.getString("image_url"));
                productListDto.add(productList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productListDto;
    }

    @Override
    public void add(ProductListDto productListDto) {
        try {
            PreparedStatement preparedStatement = Base.getConnection()
                    .prepareStatement(" call insert_product(?,?,?,?,?,?,?) " );
            preparedStatement.setString(1, productListDto.getCode());
            preparedStatement.setString(2,productListDto.getName());
            preparedStatement.setInt(3,productListDto.getPrice());
            preparedStatement.setInt(4,productListDto.getInventory());
            preparedStatement.setString(5,productListDto.getDescription());
            preparedStatement.setString(6,productListDto.getNameType());
            preparedStatement.setString(7,productListDto.getUrlImage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = Base.getConnection().prepareStatement(" delete  from items where item_id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
