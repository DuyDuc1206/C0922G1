package exercise.service.impl;

import exercise.modul.BenhNhan;
import exercise.service.IPerson;

import java.util.ArrayList;
import java.util.List;

public class PatentService  implements IPerson {
    List<BenhNhan> benhNhanList = new ArrayList<>();
    BenhNhan patent1 = new BenhNhan("BN-112","Nguyen Le","100000");
    BenhNhan patent2 = new BenhNhan("BN-112","Nguyen An","50000");
    BenhNhan patent3 = new BenhNhan("BN-113","Nguyen Nam","100000");
    BenhNhan patent4 = new BenhNhan("BN-114","Nguyen Toàn","50000");
    BenhNhan patent5 = new BenhNhan("BN-115","Nguyen Thắng","100000");
    public void display() {
        benhNhanList.add(patent1);
        benhNhanList.add(patent2);
        benhNhanList.add(patent3);
        benhNhanList.add(patent4);
        benhNhanList.add(patent5);
        for (BenhNhan benhNhan:benhNhanList){
            System.out.println(benhNhan.toString());
        }
    }
}
