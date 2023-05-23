package ss11_java_collection.bai_tap.repository.impl;

import ss11_java_collection.bai_tap.model.Product;
import ss11_java_collection.bai_tap.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("003", "rượu", 100000, 100));
        products.add(new Product("002", "nước ngọt", 300000, 100));
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
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public boolean editProduct(Product product, String id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getCode()) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }
    @Override
    public void findProduct(String name){
        for (Product find: products) {
            if (find.getName().contains(name)){
                System.out.println(find);
            }
        }
    }
}

