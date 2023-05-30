package ss16_binary_file_serialization.bai_tap.bai_2;

import ss16_binary_file_serialization.bai_tap.bai_1.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFileBinary {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("nhập đường dẫn link cần sao chép");
        String path = scanner.nextLine();
        List<Product> productList = readToFileBinary(path);
        for (Product s:productList) {
            System.out.println(s);
        }
        System.out.println("nhập đường linh cần sao chép tới ");
        String pathCopy = scanner.nextLine();
        writeToFileBinary(pathCopy,productList);
    }
    public static List<Product> readToFileBinary(String path){
        List<Product> stringList = new ArrayList<>();
        try {
            FileInputStream  fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            stringList = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return stringList;
    }
    public static void writeToFileBinary(String path, List<Product> strings){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(strings);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
