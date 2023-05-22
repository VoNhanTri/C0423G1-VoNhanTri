package ss11_java_collection.bai_tap.service.impl;

import ss11_java_collection.bai_tap.model.Product1;
import ss11_java_collection.bai_tap.repository.IProductRepository;
import ss11_java_collection.bai_tap.repository.impl.ProductRepository;
import ss11_java_collection.bai_tap.service.IProductService;

import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static Scanner scanner = new Scanner(System.in);
    private static IProductRepository productRepository = new ProductRepository();

    @Override
    public void disPlayAll() {
        List<Product1> product1s = productRepository.getAll();
        for (Product1 p : product1s) {
            System.out.println(p);
        }
    }

    @Override
    public void addProduct() {
        System.out.println("mơi bạn nhập mã sản phẩm");
        String code = scanner.nextLine();
        System.out.println("mời bạn nhập tên sa phẩm");
        String name = scanner.nextLine();
        System.out.println("mời bạn nhập giá sản phẩm");
        float price = Float.parseFloat(scanner.nextLine());
        System.out.println("mời bạn nhập số lượng");
        int quantity = Integer.parseInt(scanner.nextLine());
        Product1 product1 = new Product1(code, name, price, quantity);
        productRepository.addProduct(product1);
        System.out.println("đã thêm sản phẩm thành công");
    }

    @Override
    public void deleteProduct() {
        System.out.println("mời bạn nhập mã sản phẩm mà bạn muỗn xóa");
        String code = scanner.nextLine();
        Product1 product1 = productRepository.getByCode(code);
        if (product1 == null) {
            System.out.println("Mã sản phẩm không đúng");
        } else {
            System.out.println("bạn có muốn xóa sản phẩm có tên là" + product1.getName());
            System.out.println("1. xóa \n" +
                    "2. Không xóa");
        }
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            productRepository.removeProduct(product1);
            System.out.println("xóa thành công");
        }
    }

    @Override
    public void editProduct() {
        System.out.println("Mời bạn nhập mã sản phẩm muon sữa");
        String editCode = scanner.nextLine();
        Product1 checkCode = productRepository.getByCode(editCode);
        if (checkCode == null) {
            System.out.println("mã không tồn tại");
        }else {
            System.out.println("Nhập tên mới của sản phẩm");
            String name = scanner.nextLine();
            checkCode.setName(name);
            System.out.println("Nhập giá mơi của sản phẩm");
            float price = Float.parseFloat(scanner.nextLine());
            checkCode.setPrice(price);
            System.out.println("nhập số lượng mới của sản phẩm");
            int quantity = Integer.parseInt(scanner.nextLine());
            checkCode.setQuantity(quantity);
        }
    }
}
