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

public class CustomerService implements ICustomerService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void disPlayAllCustomer() {
        List<Customer> customerList = customerRepository.getAllCustomer();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void addCustomer() {
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
        NL:
        while (true) {
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
            switch (choiceGender) {
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
        } while (!Regex.checkIdentityCard(identityCard));
        String numberPhone;
        do {
            System.out.println("Nhập số điện thoại khách hàng");
            numberPhone = scanner.nextLine();
        } while (!Regex.checkNumPhone(numberPhone));
        String email;
        do {
            System.out.println("Nhập email Khách Hàng");
            email = scanner.nextLine();
        } while (!Regex.checkEmail(email));
        String customerType = "";
        String choiceType = "";
        CU:
        while (true) {
            System.out.println("----Chọn Hạng Khách Hàng----");
            System.out.println("1. Diamond");
            System.out.println("2. Platinum");
            System.out.println("3. Gold");
            System.out.println("4. Silver");
            System.out.println("5. Member");
            try {
                System.out.println("Mơi Nhập Lựa Chọn");
                choiceType = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
            switch (choiceType) {
                case "1":
                    customerType = "Diamond";
                    break CU;
                case "2":
                    customerType = "Platinum";
                    break CU;
                case "3":
                    customerType = "Gold";
                    break CU;
                case "4":
                    customerType = "Silver";
                    break CU;
                case "5":
                    customerType = "Member";
                    break CU;
                default:
                    System.out.println("Mời Nhập Từ 1 - 4");
                    break CU;
            }
        }
        System.out.println("Nhập địa chỉ khách hàng");
        String address = scanner.nextLine();
        Customer customer = new Customer(code, name, date, gender, identityCard, numberPhone, email, customerType, address);
        customerRepository.addCustomer(customer);
    }

    @Override
    public void editCustomer() {
        System.out.println("Nhập id khách hàng muốn sữa");
        String code = scanner.nextLine();
        Customer customer = customerRepository.getByCodeCustomer(code);
        if (customer == null) {
            System.out.println("Mã không chính xác");
        } else {
            System.out.println("chọn Mục Muốn sữa");
            System.out.println("1. Sua Ten");
            System.out.println("2. Sửa Ngày Sinh");
            System.out.println("3. Sửa Giới Tính");
            System.out.println("4. Sửa CMND");
            System.out.println("5. Sửa Số Điện Thoại");
            System.out.println("6. Sửa Email");
            System.out.println("7. Sửa Hạng Khách Hàng");
            System.out.println("8. Sửa Địa Chỉ Khách Hàng");
            String choiceEdit = "";
            while (true) {
                try {
                    System.out.println("Nhập sự lựa chọn");
                    choiceEdit = scanner.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Lỗi");
                }
            }
            switch (choiceEdit) {
                case "1":
                    String name;
                    do {
                        System.out.println("Mời sửa tên khách Hàng");
                        name = scanner.nextLine();
                    } while (!Regex.checkName(name));
                    customer.setName(name);
                    break;
                case "2":
                    String date = "";
                    do {
                        try {
                            System.out.println("Mời Sửa Ngày tháng năm sinh ");
                            date = scanner.nextLine();
                            int day = Integer.parseInt("" + date.charAt(0) + date.charAt(1));
                            int month = Integer.parseInt("" + date.charAt(3) + date.charAt(4));
                            int year = Integer.parseInt("" + date.charAt(6) + date.charAt(7));
                            LocalDate birthday = LocalDate.of(year, month, day);
                            LocalDate today = LocalDate.now();
                            int age = Period.between(birthday, today).getYears();
                            if (Regex.checkBirthDay(date) && age > 18) {
                                break;
                            } else {
                                System.out.println("Khách Hàng Chưa Đủ Tuổi");
                            }
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("Mời Nhập số");
                        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                            System.out.println("Mời Nhập ngày Thang Theo Định Dạng dd/mm.yy");
                        } catch (Exception e) {
                            System.out.println("Lỗi");
                        }
                    } while (true);
                    customer.setDate(date);
                    break;
                case "3":
                    String gender = "";
                    String checkGender = "";
                    GD:
                    while (true) {
                        System.out.println("---Chọn Giới Tính Khách Hàng");
                        System.out.println("1. Nam");
                        System.out.println("2. Nu");
                        System.out.println("3. Gioi Tính Khác");
                        try {
                            System.out.println("Nhập sự lựa chọn");
                            checkGender = scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Lỗi");
                        }
                        switch (checkGender) {
                            case "1":
                                gender = "Nam";
                                break GD;
                            case "2":
                                gender = "Nữ";
                                break GD;
                            case "3":
                                gender = "Giới tính khác";
                                break GD;
                            default:
                                System.out.println("Nhập từ 1 đến 3");
                                break GD;
                        }
                    }
                    customer.setGender(gender);
                    break;
                case "4":
                    System.out.println("Sửa CMND Khách Hàng");
                    String identityCard;
                    do {
                        System.out.println("Nhập CMND mới");
                        identityCard = scanner.nextLine();
                    } while (!Regex.checkIdentityCard(identityCard));
                    customer.setIdentityCard(identityCard);
                    break;
                case "5":
                    System.out.println("Sửa Số Điện Thoại Khách Hàng");
                    String numberPhone;
                    do {
                        System.out.println("Nhập số điện thoại mới");
                        numberPhone = scanner.nextLine();
                    } while (!Regex.checkNumPhone(numberPhone));
                    customer.setNumberPhone(numberPhone);
                    break;
                case "6":
                    System.out.println("Sửa Email Khách Hàng");
                    String email = "";
                    do {
                        System.out.println("Nhập email mới Khách Hang sau khi Sửa");
                        email = scanner.nextLine();
                    } while (!Regex.checkEmail(email));
                    customer.setEmail(email);
                    break;
                case "7":
                    System.out.println("Sửa Hang Khách Hàng");
                    String customerType = "";
                    String choiceType = "";
                    TP:
                    while (true) {
                        System.out.println("----Chọn Hạng Khách ");
                        System.out.println("1. Diamond");
                        System.out.println("2. Platinum");
                        System.out.println("3. Gold");
                        System.out.println("4. Silver");
                        System.out.println("5. Member");
                        try {
                            System.out.println("Chọn Hạng mới cho khách hàng");
                            choiceType = scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Lỗi");
                        }
                        switch (choiceType) {
                            case "1":
                                customerType = "Diamond";
                                break TP;
                            case "2":
                                customerType = "Platinum";
                                break TP;
                            case "3":
                                customerType = "Gold";
                                break TP;
                            case "4":
                                customerType = "Silver";
                                break TP;
                            case "5":
                                customerType = "Member";
                                break TP;
                            default:
                                System.out.println("Mời nhập chọn từ 1 - 5");
                                break TP;
                        }
                    }
                    customer.setCustomerType(customerType);
                    break;
                case "8":
                    System.out.println("sửa địa chỉ khách hàng");
                    String address = scanner.nextLine();
                    customer.setAddress(address);
                    break;
                default:
                    System.out.println("Nhập từ 1 - 8");
                    break;
            }
            System.out.println("Sửa thành công");
        }
        customerRepository.editCustomer();
    }

    @Override
    public void deleteCustomer() {
        System.out.println("nhập mã khách hàng bạn muốn xoa");
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
    public void findCustomer() {
        System.out.println("Nhập ten khách Hàng bạn muốn tìm kiếm");
        String name = scanner.nextLine();
        customerRepository.searchCustomer(name);
    }
}
