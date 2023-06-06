package furama_resort.repository.impl;

import furama_resort.model.facility.Facility;
import furama_resort.model.facility.House;
import furama_resort.model.facility.Room;
import furama_resort.model.facility.Villa;
import furama_resort.repository.IFacilityRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    private static final Map<Facility, Integer> facilityList = new LinkedHashMap<>();

    static {
        House house = new House("SVHO-1234", "Vui Vẻ", 100, 5000000, 4, "2 Ngày", "Thường", 2);
        Room room = new Room("SVRO-0001", "Hạnh Phúc", 20, 2000000, 2, "2 ngày", "Ăn Sáng free");
        Villa villa = new Villa("SVVL-0001", "Tận Hưởng", 500, 10000000, 10, "5 ngày", "VIP", 15, 2);
        facilityList.put(house, 5);
        facilityList.put(room, 0);
        facilityList.put(villa, 0);
    }


    @Override
    public Map<Facility, Integer> getAllFacility() {
        return facilityList;
    }

    @Override
    public List<Facility> getMaintenance() {
        List<Facility> facilityMaintainList = new ArrayList<>();
        for (Facility facility: facilityList.keySet()) {
            Integer value = facilityList.get(facility);
            if (value >=5){
                facilityMaintainList.add(facility);
            }
        }
        return facilityMaintainList;
    }

    @Override
    public void addFacility(Facility facility) {
        facilityList.put(facility, 0);
    }

    @Override
    public void deleteFacility(Facility facility) {
        facilityList.remove(facility);
    }

    @Override
    public Facility getByCode(String code) {
        for (Facility facility: facilityList.keySet()) {
            if (facility.getCode().equals(code)){
                return facility;
            }
        }
        return null;
    }
}
