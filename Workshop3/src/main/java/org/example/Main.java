package org.example;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> productList = FileManager.readProducts();

        int userInput = 0;
        System.out.println("========== EVERYDAY THEORY ==========");
        System.out.println("it's provocative and gets the people going\n");

        while (true) {
            System.out.println("===== THEORIES =====");
            System.out.println("1) Our Closet ");
            System.out.println("2) Match Your ID");
            System.out.println("3) Match your Price");
            System.out.println("4) CART");
            System.out.println("5) Exit");
            System.out.println("Please Choose Your Desired ");
            userInput = scanner.nextInt();
            scanner.nextLine();

            while (true) {
                switch (userInput) {
                    case 1:
                        System.out.println("=====Our Products=====");
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        break;

                }
            }
        }
    }
}