package org.example;

import java.util.Scanner;

public class Calculator3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------- Annuity Present Value-------");

        System.out.println("Enter Monthly Payout: ");
        int monthlyPayoutAmount = scanner.nextInt();
        System.out.println("Enter Interest Rate: ");
        double annualRate = scanner.nextDouble();
        System.out.println("How many Years: ");
        int tNumYearAnnuityPayOut = scanner.nextInt();


        double rMonthlyInterestRate = annualRate / 12 / 100;
        int nMonthlyPayments = tNumYearAnnuityPayOut * 12;
        double powerResult = Math.pow((1 + rMonthlyInterestRate), -nMonthlyPayments);

        double presentValue = monthlyPayoutAmount * (powerResult / rMonthlyInterestRate);

        System.out.printf("To fund an annuity that pays $%d monthly for %d years\n" +
                "and earns an expected %.2f interest, you would need to invest\n" +
                "$%.2f today." ,monthlyPayoutAmount,tNumYearAnnuityPayOut, annualRate, presentValue);



    }
}
