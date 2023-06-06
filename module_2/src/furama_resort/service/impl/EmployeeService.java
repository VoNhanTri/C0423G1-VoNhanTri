package furama_resort.service.impl;

import furama_resort.model.person.Employee;
import furama_resort.repository.IEmployeeRepository;
import furama_resort.repository.impl.EmployeeRepository;
import furama_resort.service.IEmployeeService;
import furama_resort.utils.Regex;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void displayAllEmployee() {
        List<Employee> employeeList = employeeRepository.getAllEmployee();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void addEmployee() {
        String code;
        do {
            System.out.println("Nhập mã nhân viên mới theo định dạng NV-XXXX");
            code = scanner.nextLine();
        } while (!Regex.checkCode(code));
        String name;
        do {
            System.out.println("Nhập tên nhân viên mới");
            name = scanner.nextLine();
        } while (!Regex.checkName(name));
        String date = "";
        do {
            try {
                System.out.println("nhập ngày tháng năm sinh mới");
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
                    System.out.println("Nhân viên chưa đủ tuổi");
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Nhập so");
            } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                System.out.println("Nhập theo định dạng dd-mm-yy");
            } catch (Exception e) {
                System.out.println("lỗi");
            }

        } while (true);

        String gender = null;
        String check = null;
        NL:
        while (true) {
            System.out.println("nhập giới tính");
            System.out.println("1. Nam");
            System.out.println("2. Nữ");
            System.out.println("3. Giới Tính Khác");
            try {
                System.out.println("Chọn Giới Tính");
                check = scanner.nextLine();
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Mời Nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
            switch (check) {
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
                    System.out.println("Hãy nhập số từ 1 đến 3");
            }
        }


        String identityCard;
        do {
            System.out.println("Nhập chứng minh nhân dân mới");
            identityCard = scanner.nextLine();
        } while (!Regex.checkIdentityCard(identityCard));
        String numberPhone;
        do {
            System.out.println("Nhap số điện thoại mới");
            numberPhone = scanner.nextLine();
        } while (!Regex.checkNumPhone(numberPhone));
        String email;
        do {
            System.out.println("Nhập email mới");
            email = scanner.nextLine();
        } while (!Regex.checkEmail(email));
        String level = "";
        String choiceLV = null;
        NLE:
        do {
            System.out.println("Chọn Trình Độ");
            System.out.println("1. Trung Cấp");
            System.out.println("2. Cao Đẳng");
            System.out.println("3. Đại Học");
            System.out.println("4. Sau Đại Học");
            try {
                System.out.println("Nhập chọn trình độ");
                choiceLV = scanner.nextLine();
            } catch (NumberFormatException numberFormatException) {
                System.out.println("mời nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
            switch (choiceLV) {
                case "1":
                    level = "Trung Cấp";
                    break NLE;
                case "2":
                    level = "Cao Đẳng";
                    break NLE;
                case "3":
                    level = "Đại Học";
                    break NLE;
                case "4":
                    level = "Sau Đại Học";
                    break NLE;
                default:
                    System.out.println("Chọn từ 1 đến 4");
            }
        } while (true);

        String position = "";
        String chose = null;
        NLB:
        do {
            System.out.println("Chọn chức vụ");
            System.out.println("1. Lễ Tân");
            System.out.println("2. Phục Vụ");
            System.out.println("3. Chuyên Viên");
            System.out.println("4. Giám Sát");
            System.out.println("5. Quản Lý");
            System.out.println("6. Giám Đốc");
            try {
                System.out.println("Nhập để chọn chức vụ");
                chose = scanner.nextLine();
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Mời nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
            switch (chose) {
                case "1":
                    position = "Lễ Tân";
                    break NLB;
                case "2":
                    position = "Phục Vụ";
                    break NLB;
                case "3":
                    position = "Chuyên Viên";
                    break NLB;
                case "4":
                    position = "Giám Sát";
                    break NLB;
                case "5":
                    position = "Quản Lý";
                    break NLB;
                case "6":
                    position = "Giám Đốc";
                    break NLB;
                default:
                    System.out.println("Hãy Nhập Từ 1 đến 6");
            }
        } while (true);
        float salary;
        while (true) {
            try {
                System.out.println("Nhập mức lương");
                salary = Float.parseFloat(scanner.nextLine());
                if (salary > 0) {
                    break;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        }
        Employee employee = new Employee(code, name, date, gender, identityCard, numberPhone, email, level, position, salary);
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void editEmployee() {
        System.out.println("nhập id muốn sửa");
        String code = scanner.nextLine();
        Employee employeeList = employeeRepository.getByCodeEmployee(code);
        if (employeeList == null) {
            System.out.println("Mã không tô tại");
        } else {
            System.out.println("Nhập mục muốn sửa");
            System.out.println("1. Sửa Tên");
            System.out.println("2. Sửa Ngày");
            System.out.println("3. Sửa giới tính");
            System.out.println("4. Sửa CMND");
            System.out.println("5. Sửa số điện thoại");
            System.out.println("6. Sửa email");
            System.out.println("7. Sửa Trình Độ");
            System.out.println("8. Sửa Chức Vụ");
            System.out.println("9. Sửa Lương");
            String choice;
            while (true){
                try {
                    System.out.println("Nhập Mục cần sửa: ");
                    choice = scanner.nextLine();
                    break;
                }catch (Exception e){
                    System.out.println("Lỗi");
                }
            }
            switch (choice) {
                case "1":
                    String name;
                    do {
                        System.out.println("Nhập tên nhân viên mới");
                        name = scanner.nextLine();
                    } while (!Regex.checkName(name));
                    employeeList.setName(name);
                    break;
                case "2":
                    String date = "";
                    do {
                        try {
                            System.out.println("nhập ngày tháng năm sinh mới");
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
                                System.out.println("Nhân viên chưa đủ tuổi");
                            }
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("Nhập so");
                        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                            System.out.println("Nhập theo định dạng dd-mm-yy");
                        } catch (Exception e) {
                            System.out.println("lỗi");
                        }

                    } while (true);
                    employeeList.setDate(date);
                    break;
                case "3":
                    String gender = null;
                    String check = null;

                    NL:
                    while (true) {
                        System.out.println("nhập giới tính");
                        System.out.println("1. Nam");
                        System.out.println("2. Nữ");
                        System.out.println("3. Giới Tính Khác");
                        try {
                            System.out.println("Chọn Giới Tính");
                            check = scanner.nextLine();
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("Mời Nhập số");
                        } catch (Exception e) {
                            System.out.println("Lỗi");
                        }
                        switch (check) {
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
                                System.out.println("Hãy nhập số từ 1 đến 3");
                                break NL;
                        }
                    }
                    employeeList.setGender(gender);
                    break;
                case "4":
                    String identityCard;
                    do {
                        System.out.println("Nhập chứng minh nhân dân mới");
                        identityCard = scanner.nextLine();
                    } while (!Regex.checkIdentityCard(identityCard));
                    employeeList.setIdentityCard(identityCard);
                    break;
                case "5":
                    String numberPhone;
                    do {
                        System.out.println("Nhap số điện thoại mới");
                        numberPhone = scanner.nextLine();
                    } while (!Regex.checkNumPhone(numberPhone));
                    employeeList.setNumberPhone(numberPhone);
                    break;
                case "6":
                    String email="";
                    do {
                        System.out.println("Sửa Email Nhan Viên");
                        email = scanner.nextLine();
                    }while (!Regex.checkEmail(email));
                    employeeList.setEmail(email);
                    break;
                case "7":
                    String level = "";
                    String choiceLV = null;
                    NLE:
                    do {
                        System.out.println("Chọn Trình Độ");
                        System.out.println("1. Trung Cấp");
                        System.out.println("2. Cao Đẳng");
                        System.out.println("3. Đại Học");
                        System.out.println("4. Sau Đại Học");
                        try {
                            System.out.println("Nhập chọn trình độ");
                            choiceLV = scanner.nextLine();
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("mời nhập số");
                        } catch (Exception e) {
                            System.out.println("Lỗi");
                        }
                        switch (choiceLV) {
                            case "1":
                                level = "Trung Cấp";
                                break NLE;
                            case "2":
                                level = "Cao Đẳng";
                                break NLE;
                            case "3":
                                level = "Đại Học";
                                break NLE;
                            case "4":
                                level = "Sau Đại Học";
                                break NLE;
                            default:
                                System.out.println("Chọn từ 1 đến 4");
                                break NLE;
                        }
                    } while (true);
                    employeeList.setLevel(level);
                    break;
                case "8":
                    String position = "";
                    String chose = null;
                    NLB:
                    do {
                        System.out.println("Chọn chức vụ");
                        System.out.println("1. Lễ Tân");
                        System.out.println("2. Phục Vụ");
                        System.out.println("3. Chuyên Viên");
                        System.out.println("4. Giám Sát");
                        System.out.println("5. Quản Lý");
                        System.out.println("6. Giám Đốc");
                        try {
                            System.out.println("Nhập để chọn chức vụ");
                            chose = scanner.nextLine();
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("Mời nhập số");
                        } catch (Exception e) {
                            System.out.println("Lỗi");
                        }
                        switch (chose) {
                            case "1":
                                position = "Lễ Tân";
                                break NLB;
                            case "2":
                                position = "Phục Vụ";
                                break NLB;
                            case "3":
                                position = "Chuyên Viên";
                                break NLB;
                            case "4":
                                position = "Giám Sát";
                                break NLB;
                            case "5":
                                position = "Quản Lý";
                                break NLB;
                            case "6":
                                position = "Giám Đốc";
                                break NLB;
                            default:
                                System.out.println("Hãy Nhập Từ 1 đến 6");
                                break NLB;
                        }
                    } while (true);
                    employeeList.setPosition(position);
                    break;
                case "9":
                    float salary;
                    while (true) {
                        try {
                            System.out.println("Nhập mức lương");
                            salary = Float.parseFloat(scanner.nextLine());
                            if (salary > 0) {
                                break;
                            }
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("nhập số");
                        } catch (Exception e) {
                            System.out.println("Lỗi");
                        }
                    }
                    employeeList.setSalary(salary);
                    break;
                default:
                    System.out.println("Nhập từ 1 đến 8");
                    break;
            }
            System.out.println("Chỉnh sưả thành công");
        }
        employeeRepository.editEmployee();
    }


    @Override
    public void deleteEmployee() {
        System.out.println("Nhập mã nhân viên muốn xóa theo định dạng NV-xxxx");
        String code = scanner.nextLine();
        Employee employee = employeeRepository.getByCodeEmployee(code);
        if (employee == null) {
            System.out.println("Mã Không tôn tại");
        } else {
            System.out.println("Bạn co muỗn xóa nhân viên có tên " + employee.getName());
            System.out.println("1. xóa");
            System.out.println("2. suy nghĩ lại");
        }
        int choice;
        do {
            try {
                System.out.println("Nhập sự lua chon");
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        } while (true);
        if (choice == 1) {
            employeeRepository.removeEmployee(employee);
            System.out.println("Xóa thành công");
        }
    }

    @Override
    public void searchEmployee() {
        System.out.println("Nhập tên nhân viên bạn muốn tìm kiếm");
        String name = scanner.nextLine();
        employeeRepository.searchEmployee(name);
    }
}
