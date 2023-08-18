package com.codegym.quan_ly.repository;

import com.codegym.quan_ly.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;
//    private static List<Product> productList = new ArrayList<>();
//
//    static {
//        productList.add(new Product(1, "Choco Pie", "150000", "banh socola", "Orion"));
//        productList.add(new Product(2, "Choco PN", "150000", "banh socola", "Pham Nguyen"));
//        productList.add(new Product(3, "Choco Nice", "150000", "banh socola", "Biscafun"));
//        productList.add(new Product(4, "Choco Lotte", "150000", "banh socola", "Lotte"));
//    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product ", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Transactional
    @Override
    public void update(int id, Product product) {
        Product product1 = findById(id);
        entityManager.merge(product1);
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setPublisher(product.getPublisher());
    }

    @Transactional
    @Override
    public void delete(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> findByName(String name) {
        name = "%" + name + "%";
       TypedQuery<Product> productTypedQuery = entityManager.createQuery("select p from Product p where p.name like :name", Product.class);
       productTypedQuery.setParameter("name", name);
        return productTypedQuery.getResultList();
    }

    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        List<Product> products = productRepository.findByName("Choco");
        for (Product s : products) {
            System.out.println(s.getName());
        }
    }
}
