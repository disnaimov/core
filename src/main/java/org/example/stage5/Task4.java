package org.example.stage5;
//Палиндром - нужно проверить, что строка является палиндромом
public class Task4 {
    private static boolean isPalindrome(String string) {
        if (string.isEmpty()) {
            return false;
        }

        string = string.toLowerCase();
        char[] chars = string.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "raceCar";
        String test2 = "hello";

        System.out.println(isPalindrome(test1));
        System.out.println(isPalindrome(test2));
    }
}
