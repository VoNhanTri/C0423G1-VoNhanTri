package ss16_binary_file_serialization.bai_tap.bai_1.controller;

import ss16_binary_file_serialization.bai_tap.bai_1.service.IProductService;
import ss16_binary_file_serialization.bai_tap.bai_1.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
   private static Scanner scanner = new Scanner(System.in);
    private static IProductService productService = new ProductService();
    public static void menu(){
        do {
            System.out.println("--------------");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    productService.disPLayALl();
                    break;
                case 2:
                    productService.addProduct();
                    break;
                case 3:
                    productService.searchProduct();
                    break;
                case 4:
                    System.exit(1);
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Nhap lại ");
                    break;
            }
        }while (true);
    }
}
