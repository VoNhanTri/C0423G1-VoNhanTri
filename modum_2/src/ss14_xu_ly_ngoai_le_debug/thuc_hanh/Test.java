package ss14_xu_ly_ngoai_le_debug.thuc_hanh;

public class Test {
    public static void main(String args[]){
        try {
            int x = 0;
            int y = 5 / x;
        }catch (ArithmeticException e) {
            System.out.println("Arithmetic");
        }catch (Exception ae) {
            System.out.println("Exception");
        }
        System.out.println("finished");
    }
}
