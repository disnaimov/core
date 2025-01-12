package org.example.stage5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Дан отсортированный список, нужно удалить все дубликаты, чтобы каждый элемент в списке встречался только один раз
 */
public class Task5 {

    // для чисел
    private static List<Integer> removeDuplicates(List<Integer> nums) {
        if (nums.isEmpty()) {
            return nums;
        }

        List<Integer> uniqueNums = new ArrayList<>();
        uniqueNums.add(nums.get(0));

        for (int i = 1; i < nums.size(); i++) {
            if (!nums.get(i).equals(nums.get(i - 1))) {
                uniqueNums.add(nums.get(i));
            }
        }

        return uniqueNums;
    }

    // для строк
    private static List<String> removeStringDuplicates(List<String> strings) {
        if (strings.isEmpty()) {
            return strings;
        }

        List<String> uniqueStrings = new ArrayList<>();
        uniqueStrings.add(strings.get(0));

        for (int i = 1; i < strings.size(); i++) {
            if (!strings.get(i).equals(strings.get(i - 1))) {
                uniqueStrings.add(strings.get(i));
            }
        }
        return uniqueStrings;
    }

    // если неотсортирован и можно сортировать
    private static List<String> sortAndRemoveDuplicates(List<String> strings) {
        if (strings.isEmpty()) {
            return strings;
        }

        Collections.sort(strings);
        List<String> uniqueStrings = new ArrayList<>();
        uniqueStrings.add(strings.get(0));

        for (int i = 1; i < strings.size(); i++) {
            if (!strings.get(i).equals(strings.get(i-1))) {
                uniqueStrings.add(strings.get(i));
            }
        }
        return uniqueStrings;
    }

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 1, 1, 2, 3, 3, 4, 4, 5);
        List<String> fruits = Arrays.asList("apple", "apple", "banana", "banana", "cherry", "date", "date", "fig");
        List<String> unsortedFruits = Arrays.asList("banana", "apple", "banana", "apple", "cherry");

        System.out.println(removeDuplicates(nums));
        System.out.println(removeStringDuplicates(fruits));
        System.out.println(sortAndRemoveDuplicates(unsortedFruits));
    }
}
