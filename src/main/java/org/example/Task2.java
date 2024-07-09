package org.example;

import java.util.Scanner;

/*
Реализовать калькулятор вкладов - на вход приложение получает сумму вклада в рублях (может быть дробной, например, 1450.85 рублей),
количество месяцев вклада (целое число) и годовой процент (может быть дробным, например, 14,5).
На выходе программа должна выдать сумму на вкладе, которая у клиента будет через указанное количество месяцев.
Причем считаем, что капитализация вклада происходит каждый месяц - то есть, по истечении каждого месяца клиенту
выплачиваются на счет проценты за прошедший месяц.
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input sum: ");
        double sum = scanner.nextDouble();

        System.out.print("Input month: ");
        int months = scanner.nextInt();

        System.out.print("Input percent: ");
        double percent = scanner.nextDouble();

        double monthRate = percent / 12 / 100;

        for (int i = 0; i < months; i++) {
            double profit  = sum * monthRate;
            sum += profit;
        }

        System.out.println("Sum is " + sum);

        scanner.close();
    }
}