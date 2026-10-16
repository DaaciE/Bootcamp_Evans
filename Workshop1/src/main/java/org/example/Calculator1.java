package org.example;

import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------Mortgage Calculator-------");


        System.out.println("Enter Loan aAmount: ");
        long principle = scanner.nextLong();
        System.out.println("Enter Interest Rate: ");
        double interestRate = scanner.nextDouble();
        System.out.println("Enter Length of Loan: ");
        int loanTermInYears = scanner.nextInt();




    }
    }