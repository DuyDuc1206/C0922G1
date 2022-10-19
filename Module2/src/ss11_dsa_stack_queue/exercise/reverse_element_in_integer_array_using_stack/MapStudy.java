package ss11_dsa_stack_queue.exercise.reverse_element_in_integer_array_using_stack;

import java.util.*;

public class MapStudy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string ");
        String string = scanner.nextLine();
        String[] strings = string.toLowerCase().split(" ");
//        String[] strings = string.toUpperCase().split(" ");
        System.out.println(Arrays.toString(strings));
        Map<String, Integer> map = new TreeMap<>();
        String key;
        Integer value;
        for (int i = 0; i < strings.length; i++) {
            key = strings[i];
            if (map.containsKey(key)) {
                value = map.get(key);
                map.remove(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        System.out.println(map);
        Set<String> sets = map.keySet();
        for (String set : sets){
            System.out.println("Từ: " + set + ", xuất hiện: " + map.get(set) + " lần");
            
        }
    }
}
