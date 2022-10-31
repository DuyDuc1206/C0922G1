package ss17_io_binary_file_serialization.exercise.model;

import java.util.Comparator;

public class SortProductById implements Comparator<Product> {
    public int compare(Product o1, Product o2){
        int compareId = Integer.compare(o1.getId(),o2.getId());
        if(compareId!=0){
            return compareId;
        }
        return o2.getProductName().compareTo(o1.getProductName());
    }
}
