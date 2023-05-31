package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static Scanner scanner = new Scanner(System.in);
    //DI
    private static IProductRepository productRepository = new ProductRepository();

    @Override
    public void displayAll() {
        //Generic
        List<Product> products = productRepository.getAll();
        for (Product p : products) {
            System.out.println(p);
        }
    }

    @Override
    public void addProduct() {
        System.out.print("Nhập mã sản phẩm: ");
        String code = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        Float price = Float.valueOf(scanner.nextLine());
        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập mô tả sản phẩm: ");
        String description = scanner.nextLine();
        Product product = new Product(code, name, price, quantity, description);
        productRepository.addProduct(product);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void deleteProduct() {
        System.out.print("Bạn muốn xóa sản phẩm nào. Vui lòng nhập mã sản phẩm: ");
        String code = scanner.nextLine();
        Product product = productRepository.getByCode(code);
        if (product == null) {
            System.out.println("Không có sản phẩm");
        } else {
            System.out.println("Bạn có muốn xóa sản phẩm với tên: " + product.getNameProduct());
            System.out.println("1. Xóa");
            System.out.println("2. Suy nghĩ lại");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                productRepository.removeProduct(product);
                System.out.println("Xóa thành công");
            }
        }
    }
}
