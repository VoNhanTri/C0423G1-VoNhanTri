package com.example.ban_hang.product.repository;

import com.example.ban_hang.Base;
import com.example.ban_hang.product.model.ProductType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeRepository implements IProductTypeRepository {
    @Override
    public List<ProductType> getAllP() {
        Statement statement = null;
        List<ProductType> productTypes = new ArrayList<>();
        try {
            statement = Base.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(" select *from item_types");
            while (resultSet.next()){
                productTypes.add(new ProductType(resultSet.getInt("item_type_id"),resultSet.getString("item_type_name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productTypes;
    }
}
