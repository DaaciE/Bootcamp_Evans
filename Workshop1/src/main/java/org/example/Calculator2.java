package org.example;

import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------Compound Interest Calculator-------");

        System.out.println("Enter Deposit Amount: ");
        int principle = scanner.nextInt();
        System.out.println("Enter Interest Rate: ");
        double annualRate = scanner.nextDouble();
        System.out.println("How many Years: ");
        int tNumberOfYears = scanner.nextInt();

        // My math: Future Value
        double rNewRate = annualRate / 100;
        int dDaysPerYear = 365;
        int nTotalNumberDays = dDaysPerYear * tNumberOfYears;
        double powerResult = Math.pow((1 + (rNewRate / dDaysPerYear)), nTotalNumberDays);
        double futureValue = principle * powerResult;


        // My math: Total Interest
        double totalInterest = futureValue - principle;

        System.out.printf("If you deposit $%d in a CD that earns %.2f interest and\n" +
                "matures in %d years, your CD's ending balance will be $%.2f and\n" +
                "you would have earned $%.2f in interest" ,principle, annualRate, tNumberOfYears,futureValue, totalInterest );


        scanner.close();


    }
}
