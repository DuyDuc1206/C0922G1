package exercise.service.impl;

import exercise.modul.BacSi;
import exercise.modul.BenhNhan;
import exercise.modul.Person;
import exercise.service.IPerson;

import java.util.LinkedHashMap;
import java.util.Map;

public class PersonService implements IPerson {
    BenhNhan patent1 = new BenhNhan("BN-112","Nguyen Le","100000");
    BenhNhan patent2 = new BenhNhan("BN-112","Nguyen An","50000");
    BenhNhan patent3 = new BenhNhan("BN-113","Nguyen Nam","100000");
    BenhNhan patent4 = new BenhNhan("BN-114","Nguyen Toàn","50000");
    BenhNhan patent5 = new BenhNhan("BN-115","Nguyen Thắng","100000");
    BacSi doctor1 = new BacSi("BS-101","Nguyễn Chín");
    BacSi doctor2 = new BacSi("BS-102","Nguyễn Tám");
    BacSi doctor3 = new BacSi("BS-103","Nguyễn Bảy");
    BacSi doctor4 = new BacSi("BS-104","Nguyễn Sáu");
    BacSi doctor5 = new BacSi("BS-105","Nguyễn Năm");
    private final Map<BacSi,BenhNhan> personMap = new LinkedHashMap<>();

    @Override
    public void display() {
       personMap.put(doctor1,patent1);
       personMap.put(doctor2,patent2);
       personMap.put(doctor3,patent3);
       personMap.put(doctor4,patent4);
       personMap.put(doctor5,patent5);
       ;
    }
}
