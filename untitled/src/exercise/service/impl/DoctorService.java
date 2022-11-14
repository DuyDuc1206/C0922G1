package exercise.service.impl;

import exercise.modul.BacSi;
import exercise.modul.BenhNhan;
import exercise.service.IPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService implements IPerson {
    BacSi doctor1 = new BacSi("BS-101","Nguyễn Chín","Man",1995);
    BacSi doctor2 = new BacSi("BS-102","Nguyễn Tám","Man",1980);
    BacSi doctor3 = new BacSi("BS-103","Nguyễn Bảy","Woman",1970);
    BacSi doctor4 = new BacSi("BS-104","Nguyễn Sáu","Woman",1985);
    BacSi doctor5 = new BacSi("BS-105","Nguyễn Năm","Man",1990);
    List<BacSi> bacSiList = new ArrayList<>();
    @Override
    public void display() {
        bacSiList.add(doctor1);
        bacSiList.add(doctor2);
        bacSiList.add(doctor3);
        bacSiList.add(doctor4);
        bacSiList.add(doctor5);
        for (BacSi bacSi:bacSiList){
            System.out.println(bacSi.toString());
        }
    }
}
