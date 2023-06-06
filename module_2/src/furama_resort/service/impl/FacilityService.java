package furama_resort.service.impl;

import furama_resort.model.facility.Facility;
import furama_resort.repository.IFacilityRepository;
import furama_resort.repository.impl.FacilityRepository;
import furama_resort.service.IFacilityService;

import java.util.Map;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void displayFacility() {
        Map<Facility, Integer> facilityIntegerMap = facilityRepository.getAllFacility();
        for (Facility facility : facilityIntegerMap.keySet()) {
            System.out.println(facility);
        }
    }

    @Override
    public void displayFacilityMaintain() {

    }

    @Override
    public void addFacility() {
        AD:
        while (true) {
            System.out.println("--- Chọn Mục Muốn Thêm");
            System.out.println("1. Room");
            System.out.println("2. House");
            System.out.println("3. Villa");
            System.out.println("4. Trở Lại");
            String choice = "";
            System.out.println("Nhập Lựa Chọn");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    RoomService.roomManager();
                    System.out.println("ok");
                    break AD;
                case "2":
                    HouseService.addNewHouse();
                    break AD;
                case "3":
                    VillaService.addVilla();
                    break AD;
                case "4":
                    return;
                default:
                    System.out.println("Nhập từ 1 đến 3");
                    break;
            }
        }
    }

    @Override
    public void deleteFacility() {
        System.out.println("Nhập mã cơ sở vật chất bạn muốn xóa");
        String code = scanner.nextLine();
        Facility facility = facilityRepository.getByCode(code);
        if (facility == null) {
            System.out.println("Ma không tồn tại");
        } else {
            System.out.println("Bạn có muốn xóa cơ sở vật chất có tên " + facility.getName());
            System.out.println("1. Xóa");
            System.out.println("2. Không xóa");
            int choice = 0;
            while (true) {
                try {
                    System.out.println("Nhập su lưa chọn");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("mời nhập số");
                } catch (Exception e) {
                    System.out.println("Lỗi");
                }
            }
            if (choice == 1) {
                facilityRepository.deleteFacility(facility);
                System.out.println("Xóa Thành công");
            }
        }
    }
}
