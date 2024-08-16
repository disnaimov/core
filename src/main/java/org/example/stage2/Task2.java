package org.example.stage2;

import java.util.HashSet;

public class Task2 {

   private static boolean checkNumber(HashSet<String> phoneNumbers,String number) {
       return phoneNumbers.contains(number);
    }


    public static void main(String[] args) {

        HashSet<String> phoneNumbers = new HashSet<>();

        phoneNumbers.add("123-456-7890");
        phoneNumbers.add("098-765-4321");
        phoneNumbers.add("555-555-5555");
        phoneNumbers.add("111-222-3333");
        phoneNumbers.add("444-444-4444");
        phoneNumbers.add("987-654-3210");
        phoneNumbers.add("222-333-4444");
        phoneNumbers.add("333-444-5555");
        phoneNumbers.add("666-777-8888");
        phoneNumbers.add("777-888-9999");

        System.out.println(checkNumber(phoneNumbers, "123123123"));
    }
}
