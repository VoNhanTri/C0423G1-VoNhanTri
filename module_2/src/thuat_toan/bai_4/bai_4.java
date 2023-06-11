package thuat_toan.bai_4;

public class bai_4 {
    public static void main(String[] args) {
        String string = "Hello";
        System.out.println(checkTest(string));
    }
    public static String checkTest(String str){
        String[] array = str.split("");
        String arr = "";
        String list = "";
        for (int i = 0; i < array.length ; i++) {
            if (array[i].equals(array[i].toUpperCase())){
                arr += " " + array[i];
            }else {
                arr +=array[i];
            }
        }
        list = arr.toLowerCase().trim();
        return list;
    }
}
