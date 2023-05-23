package ss11_java_collection.bai_tap.repository;

import ss11_java_collection.bai_tap.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> getAll();

    void addProduct(Product product);

    Product getByCode(String code);


    void removeProduct(Product product);

    boolean editProduct(Product product, String id);

    void findProduct(String name);
}
