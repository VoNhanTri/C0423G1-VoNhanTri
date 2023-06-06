package furama_resort.repository;

import furama_resort.model.facility.Facility;

import java.util.List;
import java.util.Map;

public interface IFacilityRepository{
    Map<Facility,Integer> getAllFacility();
    List<Facility> getMaintenance();
    void addFacility(Facility facility);
    void deleteFacility(Facility facility);
    Facility getByCode(String code);
}
