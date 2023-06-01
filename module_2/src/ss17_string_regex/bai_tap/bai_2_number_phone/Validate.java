package ss17_string_regex.bai_tap.bai_2_number_phone;

public class Validate {
    public static boolean checkNumberPhone(String numberPhone, String regex){
        return numberPhone.matches(regex);
    }
}
