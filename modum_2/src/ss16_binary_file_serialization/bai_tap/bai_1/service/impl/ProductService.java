package ss16_binary_file_serialization.bai_tap.bai_1.service.impl;

import ss16_binary_file_serialization.bai_tap.bai_1.model.Product;
import ss16_binary_file_serialization.bai_tap.bai_1.repository.IProductRepository;
import ss16_binary_file_serialization.bai_tap.bai_1.repository.impl.ProductRepository;
import ss16_binary_file_serialization.bai_tap.bai_1.service.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static final IProductRepository productRepository = new ProductRepository();
    private static final Scanner scanner = new Scanner(System.in);

    public void disPLayALl() {
        List<Product> productList = productRepository.getAll();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void addProduct() {
        System.out.println("nhap mã sản phẩm");
        String code = scanner.nextLine();
        System.out.println("nhập tên sản phẩm");
        String name = scanner.nextLine();
        int prince = 0;
        while (true) {
            try {
                System.out.println("nhập giá san phẩm");
                prince = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("nhâp số ");
            }
        }
        int quantity = 0;
        while (true) {
            try {
                System.out.println("nhập số lượng sản phẩm");
                quantity = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("nhập số");
            }
        }
        System.out.println("nhâp mô tả sản phẩm");
        String description = scanner.nextLine();
        Product product = new Product(code, name, prince, quantity, description);
        productRepository.addProduct(product);
        System.out.println("Đã thêm thành công");
    }

    @Override
    public void searchProduct() {
        System.out.println("Nhập tên sản phẩm muốn tìm kiếm");
        String name = scanner.nextLine();
        productRepository.searchProduct(name);
    }
}
