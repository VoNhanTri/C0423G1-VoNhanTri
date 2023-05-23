package ss11_java_collection.bai_tap.controller;

import ss11_java_collection.bai_tap.service.IProductService;
import ss11_java_collection.bai_tap.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private static IProductService productService = new ProductService();
    public static void menu(){
        do {
            System.out.println("-----------------------");
            System.out.println("Lựa chọn chức năng");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Sửa sản phẩm");
            System.out.println("5. Hiển thị danh sách sắp xếp theo giá ");
            System.out.println("6. tìm kiếm sản phẩm");
            System.out.println("0. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    productService.disPlayAll();
                    break;
                case 2:
                    productService.addProduct();
                    break;
                case 3:
                    productService.deleteProduct();
                    break;
                case 4:
                    productService.editProduct();
                    break;
                case 5:
                    productService.displayProduct();
                    break;
                case 6:
                    productService.findProduct();
                    break;
                case 0:
                    System.out.println("cảm ơn");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Nhâp lại");
                    break;
            }
        }while (true);
    }
}
