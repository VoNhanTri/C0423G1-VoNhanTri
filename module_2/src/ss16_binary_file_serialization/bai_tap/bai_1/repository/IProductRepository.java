package ss16_binary_file_serialization.bai_tap.bai_1.repository;

import ss16_binary_file_serialization.bai_tap.bai_1.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product>getAll();
    void addProduct(Product product);
    Product getByCode(String code);
    void searchProduct(String name);

}
