package demo1.service.impl;

import demo1.model.Product;
import demo1.repository.IProductRepository;
import demo1.repository.impl.ProductRepository;
import demo1.service.IProductService;

import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static Scanner scanner = new Scanner(System.in);
    private static IProductRepository productRepository = new ProductRepository();

    @Override
    public void disPlayAll() {
        List<Product> products = productRepository.getAll();
        for (Product p : products) {
            System.out.println(p);
        }
    }
    @Override
    public void addProduct(){
        System.out.println("nhập mã sản phẩm");
        String code = scanner.nextLine();
        System.out.println("nhập tn sản phẩm");
        String name = scanner.nextLine();
        System.out.println("nhập giá sản phẩm");
        float price = Float.parseFloat(scanner.nextLine());
        System.out.println("nhập số lượng sản phẩm");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập mô tả sản phẩm");
        String description = scanner.nextLine();
        Product product = new Product(code,name,price,quantity,description);
        productRepository.addProduct(product);
        System.out.println("đã thêm sản phẩm thành công");
    }

    @Override
    public void deleteProduct() {
        System.out.println("ban muỗn xóa sản phẩm nào.Mời bạn nhập Mã sản phẩm");
        String code = scanner.nextLine();
        Product product = productRepository.getByCode(code);
        if (product == null){
            System.out.println("không có sản phẩm");
        }else {
            System.out.println("Bạn có muốn xóa sản phẩm với tên "+ product.getNameProduct());
            System.out.println("1. Xóa");
            System.out.println("2. Suy nghĩ lại");
        }
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice==1){
            productRepository.removeProduct(product);
            System.out.println("xóa thành công");
        }
    }

}
