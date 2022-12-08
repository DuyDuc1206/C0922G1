package service.facility.impl;

import model.facility.FacilityType;
import repository.facility.IFacilityTypeRepository;
import repository.facility.impl.FacilityTypeRepository;
import service.facility.IFacilityTypeService;

import java.util.List;

public class FacilityTypeService implements IFacilityTypeService {
    IFacilityTypeRepository facilityTypeRepository = new FacilityTypeRepository();
    @Override
    public List<FacilityType> selectAllFacilityType() {
        return facilityTypeRepository.selectAllFacilityType();
    }
}
