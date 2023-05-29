package ss15_io_text_file.bai_tap.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFile {
    public static List<String> readToFile(String path) {
        List<String> stringList = new ArrayList<>();
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split("");
                for (String s : arr) {
                    stringList.add(s);
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi");
        } catch (IOException e) {
            System.out.println("lỗi");;
        }
        return stringList;
    }
    public void  writeToFile(String path, List<String> stringList){
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String s: stringList) {
                bufferedWriter.write(s);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("loi");;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CopyFile copyFile = new CopyFile();
        System.out.println("Nhap duong dan nguon maf ban muon sao chep");
        String path = scanner.nextLine();
        List<String> stringList = copyFile.readToFile(path);
        for (String s:stringList) {
            System.out.println(s);
        }
        System.out.println("nhap duong dan dich ma ban muon gui toi");
        String pathGoal = scanner.nextLine();
        copyFile.writeToFile(pathGoal, stringList);
    }
}
