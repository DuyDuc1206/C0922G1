package service.facility.impl;

import model.facility.Facility;
import repository.facility.IFacilityRepository;
import repository.facility.impl.FacilityRepository;
import service.facility.IFacilityService;

import java.util.List;

public class FacilityService implements IFacilityService {
    IFacilityRepository facilityRepository = new FacilityRepository();
    @Override
    public List<Facility> selectAllService() {
        return facilityRepository.selectAllService();
    }

    @Override
    public Facility seclectFacilityById(int id) {
        return facilityRepository.seclectFacilityById(id);
    }

    @Override
    public boolean deleteFacility(int id) {
        return facilityRepository.deleteFacility(id);
    }

    @Override
    public boolean addFacility(Facility facility) {
        return facilityRepository.addFacility(facility);
    }

    @Override
    public boolean updateFacility(Facility facility) {
        return facilityRepository.updateFacility(facility);
    }

}
