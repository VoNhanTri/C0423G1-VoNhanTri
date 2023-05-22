package ss11_java_collection.bai_tap.repository.impl;

import ss11_java_collection.bai_tap.model.Product1;
import ss11_java_collection.bai_tap.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product1> products = new ArrayList<>();

    static {
        products.add(new Product1("001", "rượu", 100000, 100));
        products.add(new Product1("002", "nước ngọt", 30000, 100));
    }

    @Override
    public List<Product1> getAll() {
        return products;
    }

    @Override
    public void addProduct(Product1 product) {
        products.add(product);
    }

    @Override
    public Product1 getByCode(String code) {
        for (Product1 product : products) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void removeProduct(Product1 product) {
        products.remove(product);
    }

    @Override
    public boolean editProduct(Product1 product, String id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getCode()) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }
}

