package ss16_binary_file_serialization.bai_tap.bai_1.comon;

import ss16_binary_file_serialization.bai_tap.bai_1.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadAndWriteToFile implements Serializable {
    public static void writeToFile(String path, List<Product> products){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readToFile(String path){
        List<Product> productList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);
          productList = (List<Product>) objectInputStream.readObject();
          objectInputStream.close();
          fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}