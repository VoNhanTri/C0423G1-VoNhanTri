package ss13_thuat_toan_sap_xep.bai_tap;

public class InsertSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void insertionSort(int[] list) {
        int pos;
        int element;
        for (int i = 1; i < list.length; i++) {// duyệt mảng từ vị tri thứ 1;
            element = list[i]; // element bằng giá trị thứ i trong mảng
            pos = i;//pos bằng vị tri thứ i;
            while (pos > 0 && element < list[pos - 1]) {// vị trí pos phải lớn hơn 0(tránh trường hợp pos giảm dần xuống âm) và giá trị element nhỏ hơn giá trị trước nó
                list[pos] = list[pos - 1]; //thì đổi chỗ vị trí list[pos] = list[pos-1]
                pos--;//pos giảm dần
            }
            list[pos] = element; //vị trí pos trong mảng sẽ gán giá trị element;
        }
    }

    public static void main(String[] args) {
        insertionSort(list); //gọi hàm sắp xếp insertion
        for (int i = 0; i < list.length; i++) { // duyệt và in mảng đã sắp xếp
            System.out.print(list[i] + " ");
        }
    }
}
