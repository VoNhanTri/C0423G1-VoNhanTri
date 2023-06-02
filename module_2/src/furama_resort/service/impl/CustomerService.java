package furama_resort.service.impl;

import furama_resort.model.person.Customer;
import furama_resort.repository.ICustomerRepository;
import furama_resort.repository.impl.CustomerRepository;
import furama_resort.service.ICustomerService;
import furama_resort.service.IEmployeeService;
import furama_resort.utils.Regex;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements IEmployeeService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void displayAllEmployee() {
        List<Customer> customerList = customerRepository.getAllCustomer();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void addEmployee() {
        String code;
        do {
            System.out.println("Nhap mã khách hàng bạn muốn thêm theo định dạng KH-YYYY");
            code = scanner.nextLine();
        } while (!Regex.checkCodeCustomer(code));
        String name;
        do {
            System.out.println("Nhập tên khách hàng bạn muon thêm");
            name = scanner.nextLine();
        } while (!Regex.checkName(name));
        String date;
        do {
            try {
                System.out.println("nhập ngày tháng năm sinh");
                date = scanner.nextLine();
                int day = Integer.parseInt("" + date.charAt(0) + date.charAt(1));
                int month = Integer.parseInt("" + date.charAt(3) + date.charAt(4));
                int year = Integer.parseInt("" + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9));
                LocalDate birthday = LocalDate.of(year, month, day);
                LocalDate today = LocalDate.now();
                int age = Period.between(birthday, today).getYears();
                if (Regex.checkBirthDay(date) && age >= 18) {
                    break;
                } else {
                    System.out.println("Khách Hàng Chưa đủ 18 tuổi");
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Mời Nhập Số");
            } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                System.out.println("Nhập theo định dạng dd/mm/yy");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        } while (true);
        String gender = "";
        String choiceGender = "";
     NL:   while (true) {
            System.out.println("---Chọn Giới Tính");
            System.out.println("1. Nam");
            System.out.println("2. Nữ");
            System.out.println("3. Giới Tính Khác");
            try {
                System.out.println("Mời chọn giới tính");
                choiceGender = scanner.nextLine();
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Nhập Số");
            } catch (Exception e) {
                System.out.println("Lôi");
            }
            switch (choiceGender){
                case "1":
                    gender = "Nam";
                    break NL;
                case "2":
                    gender = "Nữ";
                    break NL;
                case "3":
                    gender = "Giới Tính Khác";
                    break NL;
                default:
                    System.out.println("Nhập từ 1 đến 3");
                    break NL;
            }
        }
        String identityCard;
        do {
            System.out.println("Nhập CMND khách hàng");
            identityCard = scanner.nextLine();
        }while (!Regex.checkIdentityCard(identityCard));
        String numberPhone;
        do {
            System.out.println("Nhập số điện thoại khách hàng");
            numberPhone = scanner.nextLine();
        }while (!Regex.checkNumPhone(numberPhone));
        String email;
        do {
            System.out.println("Nhập email Khách Hàng");
            email = scanner.nextLine();
        }while (!Regex.checkEmail(email));
        String customerType;
        String choiceType;
        while (true){

        }
    }

    @Override
    public void editEmployee() {

    }

    @Override
    public void deleteEmployee() {
        System.out.println("nhập mã nhân viên bạn muốn xoa");
        String code = scanner.nextLine();
        Customer customer = customerRepository.getByCodeCustomer(code);
        if (customer == null) {
            System.out.println("mã không tồn tại");
        } else {
            System.out.println("Bạn có muốn xóa khách hàng có tên " + customer.getName());
            System.out.println("1. Xóa");
            System.out.println("2. Không Xóa");
        }
        int choice = 0;
        do {
            try {
                System.out.println("Nhập sự lựa chọn");
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("mời bạn nập số");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        } while (true);
        if (choice == 1) {
            customerRepository.deleteCustomer(customer);
            System.out.println("xóa thành công");
        }
    }

    @Override
    public void searchEmployee() {
        System.out.println("Nhập ten khách Hàng bạn muốn tìm kiếm");
        String name = scanner.nextLine();
        customerRepository.searchCustomer(name);
    }
}
