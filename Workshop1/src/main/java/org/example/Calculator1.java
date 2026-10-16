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

//


        double iMonthlyInterest = rAnnualRate / 12 / 100;
        int numMonthPayment = yLoanLength * 12;

        double MonthlyPayment1 = Math.pow(iMonthlyInterest * (1 +iMonthlyInterest), numMonthPayment);
        double MonthlyPayment2 = Math.pow()



        double totalInterest = ( * numMonthPayment) - principle;



    }
    }