package org.example;

import java.util.Scanner;

public class Calculator3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------- Annuity Present Value-------");

        System.out.println("Enter Monthly Payout: ");
        double monthlyPayout = scanner.nextDouble();
        System.out.println("Enter Interest Rate: ");
        double annualRate = scanner.nextDouble();
        System.out.println("How many Years: ");
        int numYearAnnuityPayOut = scanner.nextInt();




        scanner.close();

    }
}
