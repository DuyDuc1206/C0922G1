package case_study.Utils;

import case_study.model.Booking;

import java.util.Comparator;

public class CompareBooking implements Comparator<Booking> {
    public int compare(Booking o1,Booking o2){
//        int compareStartDate = Integer.compare(o1.getStartDate(),o2.getStartDate());
//        if(compareStartDate!= 0){
//            return compareStartDate;
//        }
        return o1.getEndDate().compareTo(o2.getEndDate());
    }
}
