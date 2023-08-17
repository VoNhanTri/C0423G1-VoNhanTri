package com.codegym.quan_ly.repository;

import com.codegym.quan_ly.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Choco Pie","150000","banh socola","Orion"));
        productList.add(new Product(2,"Choco PN","150000","banh socola","Pham Nguyen"));
        productList.add(new Product(3,"Choco Nice","150000","banh socola","Biscafun"));
        productList.add(new Product(4,"Choco Lotte","150000","banh socola","Lotte"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product p: productList) {
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (Product p: productList) {
            if (p.getId()==id){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setPublisher(product.getPublisher());
            }
        }

    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }
}
