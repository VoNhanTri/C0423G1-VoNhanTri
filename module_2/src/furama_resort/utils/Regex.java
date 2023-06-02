package furama_resort.utils;

public class Regex {
    public static boolean checkCode(String code){
        return code.matches("^NV-\\d{4}$");
    }
    public static boolean checkName(String name){
        return  name.matches("^\\b[A-Z][a-z]*( [A-Z][a-z]*)*\\b$");
    }
    public static boolean checkBirthDay(String day){
        return day.matches("^\\d{2}(/|-)\\d{2}(/|-)\\d{4}$");
    }
    public static boolean checkIdentityCard(String idCard){
        return idCard.matches("^\\d{12}|\\d{9}$");
    }
    public static boolean checkNumPhone(String numPhone){
        return numPhone.matches("^0\\d{9}$");
    }
    public static boolean checkEmail(String email){
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
    public static boolean checkCodeCustomer(String code){
        return code.matches("^KH-\\d{4}$");
    }
}
