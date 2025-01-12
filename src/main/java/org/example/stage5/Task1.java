package org.example.stage5;

import java.util.List;
//Просуммировать числа в stream api
public class Task1 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 20, 30);

       int sum = nums.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);
    }
}
