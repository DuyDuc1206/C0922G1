package service.facility;

import model.facility.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> selectAllService();
    Facility seclectFacilityById(int id);
    boolean deleteFacility(int id);
    boolean addFacility(Facility facility);
    boolean updateFacility(Facility facility);
}
