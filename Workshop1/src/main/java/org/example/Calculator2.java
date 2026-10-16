package org.example;

import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------Compound Interest Calculator-------");

        System.out.println("Enter Deposit Amount: ");
        double principle = scanner.nextLong();
        System.out.println("Enter Interest Rate: ");
        double annualRate = scanner.nextDouble();
        System.out.println("How many Years: ");
        int tNumberOfYears = scanner.nextInt();

        // My math:
        double rNewRate = annualRate / 100;
        int dDaysPerYear = 365;
        int nTotalNumberDays = dDaysPerYear * tNumberOfYears;
        double powerResult = Math.pow((1 + (rNewRate / dDaysPerYear)), nTotalNumberDays);
        double futureValue = principle * powerResult;
        System.out.println(futureValue);




        scanner.close();


    }
}
