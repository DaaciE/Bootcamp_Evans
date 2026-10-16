package org.example;

import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------Mortgage Calculator-------");


        System.out.println("Enter Loan aAmount: ");
        long principle = scanner.nextLong();
        System.out.println("Enter Interest Rate: ");
        double rAnnualRate = scanner.nextDouble();
        System.out.println("Enter Length of Loan: ");
        int yLoanLength = scanner.nextInt();

    // My Math Breakdown:
        double iMonthlyInterest = rAnnualRate / 12 / 100;
        int numMonthPayment = yLoanLength * 12;

        double powerResult = Math.pow((1 + iMonthlyInterest) , numMonthPayment);
        double monthlyPayment = principle * (iMonthlyInterest * powerResult) / (powerResult - 1);

        double totalInterest = (monthlyPayment * numMonthPayment) - principle;

        System.out.printf("A %d loan at %.2f interest for %d years would have a\n" +
                "%.2f/mo payment with a total interest of $%.2f" ,principle, rAnnualRate, yLoanLength, monthlyPayment, totalInterest);

        scanner.close();

    }
    }