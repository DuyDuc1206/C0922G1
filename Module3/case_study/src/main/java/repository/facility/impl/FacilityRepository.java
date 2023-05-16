package repository.facility.impl;

import model.facility.RentType;
import model.facility.Facility;
import model.facility.FacilityType;
import repository.BaseRepository;
import repository.facility.IFacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private static final String SELECT_FACILITY = "select f.facility_id,f.facility_name,f.area,f.cost,f.max_people,f.standard_room,f.description_other_convenience,f.pool_area,f.number_of_floor,f.facility_free, ft.facility_type_name,rt.rent_type_name from facility as f \n" +
            "join facility_type as ft on f.facility_type_id = ft.facility_type_id\n" +
            "join rent_type as rt on f.rent_type_id = rt.rent_type_id;";

    private static final String SELECT_FACILITY_BY_ID = "select f.facility_id,f.facility_name,f.area,f.cost,f.max_people,f.standard_room,f.description_other_convenience,f.pool_area,f.number_of_floor,f.facility_free, ft.facility_type_name,rt.rent_type_name from facility as f \n" +
            "join facility_type as ft on f.facility_type_id = ft.facility_type_id\n" +
            "join rent_type as rt on f.rent_type_id = rt.rent_type_id\n" +
            "where facility_id = ?;";
    private static final String DELETE_FACILITY = "delete from facility where facility_id = ?;";
    private static final String UPDATE_FACILITY = "update facility set facility_name = ?,area=?,cost=?,max_people=?,standard_room=?,description_other_convenience=?,pool_area=?,number_of_floor=?,facility_free=?,rent_type_id=?,facility_type_id=? where facility_id =? ;\n";
    private static final String ADD_FACILITY_VILLA = "insert into facility (facility_name,area,cost,max_people,standard_room,description_other_convenience,pool_area,number_of_floor,rent_type_id,facility_type_id) \n" +
            "values (?,?,?,?,?,?,?,?,?,?);";
    private final String ADD_FACILITY_HOUSE = "insert into facility(facility_name, area, cost, max_people, standard_room, description_other_convenience, number_of_floor, rent_type_id, facility_type_id)\n" +
            "value (?,?,?,?,?,?,?,?,?,?);";
    private final String ADD_FACILITY_ROOM = "insert into facility(facility_name, area, cost, max_people, standard_room, description_other_convenience, facility_free, rent_type_id, facility_type_id)\n" +
            "value (?,?,?,?,?,?,?,?,?);";

    @Override
    public List<Facility> selectAllService() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_FACILITY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("facility_id");
                String name = rs.getString("facility_name");
                int area = rs.getInt("area");
                double cost = rs.getDouble("cost");
                int people = rs.getInt("max_people");
                String standardRoom = rs.getString("standard_room");
                String DESC = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numFloor = rs.getInt("number_of_floor");
                String facilityFree = rs.getString("facility_free");
                String rentTypeName = rs.getString("rent_type_name");
                String facilityTypeName = rs.getString("facility_type_name");
                RentType rentName = new RentType(rentTypeName);
                FacilityType facilityName = new FacilityType(facilityTypeName);
                Facility facility = new Facility(id, name, area, cost, people, standardRoom, DESC, poolArea, numFloor, facilityFree, rentName, facilityName);
                facilityList.add(facility);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityList;
    }

    @Override
    public Facility seclectFacilityById(int id) {
        Facility facility = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_FACILITY_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("facility_id");
                String name = rs.getString("facility_name");
                int area = rs.getInt("area");
                double cost = rs.getDouble("cost");
                int maxPeople = rs.getInt("max_people");
                String standard = rs.getString("standard_room");
                String desc = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberFloor = rs.getInt("number_of_floor");
                String facilityFree = rs.getString("facility_free");
                String facilityName = rs.getString("facility_type_name");
                FacilityType facilityTypeName = new FacilityType(facilityName);
                String rentName = rs.getString("rent_type_name");
                RentType rentTypeName = new RentType(rentName);
                facility = new Facility(id1, name, area, cost, maxPeople, standard, desc, poolArea, numberFloor, facilityFree, rentTypeName, facilityTypeName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facility;
    }

    @Override
    public boolean deleteFacility(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_FACILITY);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addFacility(Facility facility) {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement ps = null;
        try {
            if (facility.getFacilityTypeId() == 1) {
                ps = connection.prepareStatement(ADD_FACILITY_VILLA);
                ps.setString(1,facility.getName());
                ps.setInt(2,facility.getArea());
                ps.setDouble(3,facility.getCost());
                ps.setInt(4,facility.getMaxPeople());
                ps.setString(5,facility.getStandardRoom());
                ps.setString(6,facility.getDescriptionOtherConvenience());
                ps.setDouble(7,facility.getPoolArea());
                ps.setInt(8,facility.getNumberOfFloor());
                ps.setInt(9,facility.getRentTypeId());
                ps.setInt(10,facility.getFacilityTypeId());
            } else if(facility.getFacilityTypeId()==2){
                ps = connection.prepareStatement(ADD_FACILITY_HOUSE);
                ps.setString(1,facility.getName());
                ps.setInt(2,facility.getArea());
                ps.setDouble(3,facility.getCost());
                ps.setInt(4,facility.getMaxPeople());
                ps.setString(5,facility.getStandardRoom());
                ps.setString(6,facility.getDescriptionOtherConvenience());
                ps.setInt(7,facility.getNumberOfFloor());
                ps.setInt(8,facility.getRentTypeId());
                ps.setInt(9,facility.getFacilityTypeId());
            } else {
                ps = connection.prepareStatement(ADD_FACILITY_ROOM);
                ps.setString(1,facility.getName());
                ps.setInt(2,facility.getArea());
                ps.setDouble(3,facility.getCost());
                ps.setInt(4,facility.getMaxPeople());
                ps.setString(5,facility.getStandardRoom());
                ps.setString(6,facility.getDescriptionOtherConvenience());
                ps.setString(7,facility.getFacilityFree());
                ps.setInt(8,facility.getRentTypeId());
                ps.setInt(9,facility.getFacilityTypeId());
            }
            return ps.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateFacility(Facility facility) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_FACILITY);
            ps.setString(1, facility.getName());
            ps.setInt(2, facility.getArea());
            ps.setDouble(3, facility.getCost());
            ps.setInt(4, facility.getMaxPeople());
            ps.setString(5, facility.getStandardRoom());
            ps.setString(6, facility.getDescriptionOtherConvenience());
            ps.setDouble(7, facility.getPoolArea());
            ps.setInt(8, facility.getNumberOfFloor());
            ps.setString(9, facility.getFacilityFree());
            ps.setInt(10, facility.getRentTypeId());
            ps.setInt(11, facility.getFacilityTypeId());
            ps.setInt(12, facility.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
