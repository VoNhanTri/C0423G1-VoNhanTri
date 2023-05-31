package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    void addProduct(Product product);

    Product getByCode(String code);

    void removeProduct(Product product);
}
