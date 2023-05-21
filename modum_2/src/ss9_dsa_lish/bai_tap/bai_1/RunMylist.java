package ss9_dsa_lish.bai_tap.bai_1;

public class RunMylist {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1, 3);
        listInteger.add(2,4);
        listInteger.add(3,5);
        System.out.println("element 3: " + listInteger.get(1));
        System.out.println("element 2: " + listInteger.get(2));
        System.out.println("element 1: " + listInteger.get(3));
        System.out.println(listInteger);
        listInteger.remove(1);
        System.out.println(listInteger);
        listInteger.clear();
        System.out.println("mảng sau khi clear: "+listInteger);
    }
}
