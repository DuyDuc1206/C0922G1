package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
    }

    int solution(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(i);
        }
        Set<Integer> num = new TreeSet<>(arr);
        List<Integer> integers = new ArrayList<>(num);
        int a=integers.size();
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) != i) {
                a=i;
            }
        }
        return a;
    }
}
