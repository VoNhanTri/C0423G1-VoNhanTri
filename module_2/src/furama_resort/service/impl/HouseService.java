package furama_resort.service.impl;

import furama_resort.model.facility.House;
import furama_resort.repository.IFacilityRepository;
import furama_resort.repository.impl.FacilityRepository;
import furama_resort.utils.Regex;

import java.util.Scanner;

public class HouseService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IFacilityRepository facilityHouse = new FacilityRepository();

    public static void addNewHouse() {
        //String code, String name, float area, long expense, int quantity, String rentalType, String roomStandard, int floorNum
        String code;
        do {
            System.out.println("Mời Nhập Mã Cơ Sở Vật Chât Của Room với định dạng SVHO-YYYY");
            code = scanner.nextLine();
        } while (!Regex.checkCodeHouse(code));
        String name;
        do {
            System.out.println("Nhập Tên dịch vụ");
            name = scanner.nextLine();
        } while (!Regex.checkName(name));
        float area;
        while (true) {
            try {
                System.out.println("Nhập diện tích nhà");
                area = Float.parseFloat(scanner.nextLine());
                if (area > 30) {
                    break;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Mời Nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        }
        long expense;
        while (true) {
            try {
                System.out.println("Nhập chi phí thuê nhà");
                expense = Long.parseLong(scanner.nextLine());
                if (expense > 0) {
                    break;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        }
        int quantity;
        while (true) {
            try {
                System.out.println("Nhập số lượng nguời ở tối đa");
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity > 0 && quantity < 20) {
                    break;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        }
        String rentalType = "";
        RT:
        while (true) {
            System.out.println("--Chọn Hình Thức Thuê");
            System.out.println("1. Theo Gio");
            System.out.println("2. Theo Ngày");
            System.out.println("3. Theo Tháng");
            System.out.println("4. Theo Năm");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    rentalType = "Theo Giờ";
                    break RT;
                case "2":
                    rentalType = "Theo Ngày";
                    break RT;
                case "3":
                    rentalType = "Theo Tháng";
                    break RT;
                case "4":
                    rentalType = "Theo Năm";
                    break RT;
                default:
                    System.out.println("Nhập từ 1 -4");
                    break RT;
            }
        }
        System.out.println("Nhập Chất Lượng Phòng");
        String roomStander = scanner.nextLine();
        int floor;
        while (true) {
            try {
                System.out.println("Nhập số tầng");
                floor = Integer.parseInt(scanner.nextLine());
                if (floor > 0) {
                    break;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Nhập số");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        }
        House house = new House(code,name,area,expense,quantity,rentalType,roomStander,floor);
        facilityHouse.addFacility(house);
    }
}
