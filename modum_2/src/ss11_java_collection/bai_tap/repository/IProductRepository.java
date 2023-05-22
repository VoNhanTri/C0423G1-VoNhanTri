package ss11_java_collection.bai_tap.repository;

import ss11_java_collection.bai_tap.model.Product1;

import java.util.List;

public interface IProductRepository {

    List<Product1> getAll();

    void addProduct(Product1 product);

    Product1 getByCode(String code);


    void removeProduct(Product1 product);

    boolean editProduct(Product1 product, String id);

    boolean findProduct(String name);
}
