package ss15_io_text_file.bai_tap.doc_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) {
        List<Nation> nationList = readNationListFormFile("E:\\codegym\\codegym\\modum_2\\src\\ss15_io_text_file\\bai_tap\\doc_file_csv\\text.csv");
        for (Nation nation: nationList) {
            System.out.println(nation);
        }
    }
   public static List<Nation> readNationListFormFile(String path){
        List<Nation> nationList = new ArrayList<>();
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line= bufferedReader.readLine())!= null){
                String[] nationArr = line.split(",");
                Nation nation = new Nation(Integer.parseInt(nationArr[0]),nationArr[1],nationArr[2]);
                nationList.add(nation);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nationList;
    }
}
