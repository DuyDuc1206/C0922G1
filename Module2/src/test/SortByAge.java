package test;

import java.util.Comparator;

public class SortByAge implements Comparator<Student> {
    public int compare(Student o1, Student o2){
        int compareAge = Double.compare(o1.getAge(),o2.getAge());
        if (compareAge!=0){
            return compareAge;
        }
        return o1.getName().compareTo(o2.getName());
    }
}
