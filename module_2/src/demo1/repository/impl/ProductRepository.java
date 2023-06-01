package demo1.repository.impl;

import demo1.model.Product;
import demo1.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("P-001", "Chocolate", 40000, 25, "Bánh socola"));
        products.add(new Product("P-002", "Coca-cola", 43000, 20, "Nước ngọt"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public Product getByCode(String code) {
        for (Product product : products) {
            if (product.getCodeProduct().equals(code)) ;
            return product;

        }
        return null;
    }
    @Override
    public void removeProduct(Product product) {
        products.remove(product);

    }
}
