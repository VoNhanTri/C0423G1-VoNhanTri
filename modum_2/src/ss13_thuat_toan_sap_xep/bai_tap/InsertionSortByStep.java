package ss13_thuat_toan_sap_xep.bai_tap;

import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập độ dài của mảng");
        int size;
        do {
            size = Integer.parseInt(scanner.nextLine());
        } while (size < 0);
        int[] array = new int[size];
        System.out.println("nhập phần tử của mảng ");
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("hiển thị mảng ban đầu" + "\n");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        insertionSortByStep(array); //gọi hàm insertionSortByStep để sắp xếp mảng array
    }

    public static void insertionSortByStep(int[] array) {
        //tạo biến element;
        int element;
        // tạo biến pos;
        int pos;
        //tao biến cờ với giá trị là false
        boolean flag = false;
        //duyệt mảng từ vị trí thứ 1
        for (int i = 1; i < array.length; i++) {
            // element bằng giá trị thứ i trong mảng
            element = array[i];
            //pos bằng vị trí thu i
            pos = i;
            // vị trí pos phải lớn hơn 0(tránh trường hợp pos giảm dần xuống âm) và giá trị element nhỏ hơn giá trị trước nó
            while (pos > 0 && element < array[pos - 1]) {
                System.out.println("Hoán đổi " + array[pos] + " với " + array[pos - 1]);
                //neu thỏa điều kiện thì đổi chỗ vị trí list[pos] = list[pos-1]
                array[pos] = array[pos - 1];
                pos--;
                flag = true;
            }
            //giá trị array[pos] gán thành giá trị element;
            array[pos] = element;
            if (flag) {
                //flag = true, thì in ra danh sach đã sắp xếp lần thứ i
                System.out.print("danh sach sau khi sắp xếp " + i + ": ");
                for (int j = 0; j < array.length; j++) {
                    System.out.print(array[j] + "\t");
                }
                System.out.println();
            }
            //chạy vòng lặp tiếp theo
        }
        System.out.println("danh sách đã đước sắp xếp");
    }
}

