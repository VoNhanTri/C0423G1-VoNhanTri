package demo1.controller;

import demo1.service.IProductService;
import demo1.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private static IProductService productService = new ProductService();
    public static void menu(){
        do {
            System.out.println("---------------------------");
            System.out.println("Lựa chọn chức năng: ");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm mới Sản pẩm");
            System.out.println("3. Xóa sản phẩm");
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
                case 0:
                    System.out.println("cảm ơn đã mua hàng");
                    System.exit(1);
            }
        }while (true);
    }

}
