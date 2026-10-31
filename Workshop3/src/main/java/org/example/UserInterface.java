package org.example;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private List<Product> productList;

    public UserInterface(List<Product> productList) {
        this.productList = productList;
    }


    public void DisplayHomeScreen() {
        // Main menu
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("3")) {
            System.out.println("===== THEORIES =====");
            System.out.println("1) Our Closet ");
            System.out.println("2) CART");
            System.out.println("3) Exit");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    //Display clothing items and search through them
                    displayClosetMenu();
                    break;

                case "2":
                    // Cart menu

                    break;

                case "3":
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Please Choose Valid Option.\n");
                    break;
            }

        }
    }



    private void displayClosetMenu() {
        // Ask which search method they want
        Scanner scanner = new Scanner(System.in);
        String closetInput = "";

        while (!closetInput.equals("3")) {
            System.out.println("======== THE DETAILS BEHIND THE THEORY ========");
            System.out.println("1) OUT ENTIRE CLOSET ");
            System.out.println("2) SEARCH");
            System.out.println("2) Back to Closet");
            closetInput = scanner.nextLine();


            switch (closetInput) {
                case "1":
                    System.out.println("\n======== PUT YOUR TINFOIL HAT ON ========\n");
                    displayProducts();
                    break;

                case "2":
                    System.out.println("======== FIND THE THEORY THAT FITS ========");

                    System.out.printf("What are you searching for?:");
                    closetInput = scanner.nextLine();
                    if(closetInput ){
                        searchByName(productList, closetInput);
                }
                    else if () {
                        searchBySku(productList, closetInput);
                    } else if(){
                        searchByDepartment();
                    }






                case "3":
                    System.out.println("");
                    break;
                default:
                    System.out.println("Please Choose Valid Option.\n");

            }
        }
    }
    private void displayProducts() {
        // Display all products
        System.out.println("=====Our Products=====");

        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            System.out.printf("id: %s %s - Price: $%.2f%n",
                    p.getSku(), p.getClothingItem(), p.getPrice());

        }
    }
    private void searchByName(List<Product> productList, String clothingItem) {
        // Search by product name
        for (Product product : productList) {
            if (product.getClothingItem().equalsIgnoreCase(clothingItem)) {
                System.out.println("YOUR FINDINGS, COLLECTED!");
                System.out.printf("%s| (%s) %s", product.getCategory(), product.getSku(), product.getClothingItem());
                System.out.println("");

                return;
            }
        }
        System.out.println("FINDINGS DEBUNKED!");
    }

    private void searchBySku(List<Product> productList, String sku) {
        // Search by SKU
        for (Product product : productList) {
            if (product.getSku().equalsIgnoreCase(sku)) {
                System.out.println("YOUR FINDINGS, COLLECTED!");
                System.out.printf("%s| (%s) %s", product.getCategory(), product.getSku(), product.getClothingItem());
                System.out.println("");

                return;
            }
        }
        System.out.println("FINDINGS DEBUNKED!");
    }

    private void searchByDepartment(List<Product> productList, String category) {
        // Search by Department
        boolean found = false;

        for (Product product : productList) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                found = true;
                System.out.println("YOUR FINDINGS, COLLECTED!");
                System.out.printf("%s| (%s) %s", product.getCategory(), product.getSku(), product.getClothingItem());
                System.out.println("");
            }
        }
        if(!found) {
            System.out.println("FINDINGS DEBUNKED!");
        }
    }
}




