package luyen_m_v_c.controller;

import java.util.Scanner;

public class ProductController {
    private static final Scanner scanner = new Scanner(System.in);
    public static void menu(){
        System.out.println("----Hệ Thống Quản Lý----");
        System.out.println("1. Hiển Thị Danh Sách");
        System.out.println("2. Thêm Sản Phẩm");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Tìm Kiếm Sản Phẩm");
        System.out.println("5. Thoát");
    }
}
