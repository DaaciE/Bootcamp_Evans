package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private List<Product> productList;

    public UserInterface(List<Product> productList) {
        this.productList = productList;
    }


    public void DisplayScreen() {
        // Main menu
        Scanner scanner = new Scanner(System.in);
        int userInput = -1;

        while (userInput != 4) {
            System.out.println("\n===== THEORIES =====");
            System.out.println("1) Our Closet ");
            System.out.println("2) SEARCH");
            System.out.println("3) CART");
            System.out.println("4) Exit");

            try {
                userInput = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception ex) {
                System.out.println("Invalid Choice, Try Again.");
                userInput = Integer.parseInt(scanner.nextLine());

            }

        }
    }























        private void displayProducts () {
            // Display all products
            System.out.println("=====Our Products=====");

            for (int i = 0; i < productList.size(); i++) {
                Product p = productList.get(i);
                System.out.printf("id: %s %s - Price: $%.2f%n",
                        p.getSku(), p.getClothingItem(), p.getPrice());

            }
        }

        private void displaySearchMenu () {
            // Ask which search method they want
            System.out.println("Are You Searching By..");
            System.out.println("1) SKU");
            System.out.println("2) Price Range");
        }


        private void searchByName () {
            // Search by product name
        }

        private void searchByDepartment () {
            // Search by SKU

        }

        private void searchBySku () {
            // Search by price range
        }
    }

