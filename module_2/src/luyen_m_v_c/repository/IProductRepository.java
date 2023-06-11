package luyen_m_v_c.repository;

import luyen_m_v_c.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();
    void addProduct(Product product);
    void deleteProduct(Product product);
    void searchProduct(String name);
    Product getByCode(String code);
}
