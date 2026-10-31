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
        int userInput = -1;

        while (userInput != 3) {
            System.out.println("===== THEORIES =====");
            System.out.println("1) Our Closet ");
            System.out.println("2) CART");
            System.out.println("3) Exit");

            try {
                userInput = Integer.parseInt(scanner.nextLine());
            } catch (InputMismatchException ex) {
                System.out.println("Wrong Data Type.\n");
            } catch (NumberFormatException ex) {
                System.out.println(" Incorrect Number Format.\n");
            } catch (Exception ex) {
                System.out.println("Error.\n");
            }

            switch (userInput) {
                case 1:
                    //Display clothing items and search through them
                    displayClosetMenu();
                    break;


                case 2:
                    // Cart menu

                    break;

                case 3:
                    System.out.println("Goodbye!");
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

    private void displayClosetMenu() {
        // Ask which search method they want
        Scanner scanner = new Scanner(System.in);
        int closetInput = -1;

        while (closetInput != 3) {
            System.out.println("======== THE DETAILS BEHIND THE THEORY ========");
            System.out.println("1) Our Entire Closet");
            System.out.println("2) Search");
            System.out.println("3) Back to Closet");

            try {
                closetInput = Integer.parseInt(scanner.nextLine());
            }
            catch (InputMismatchException ex) {
                System.out.println("Wrong Data Type.");
            }
            catch (NumberFormatException ex) {
                System.out.println(" Incorrect Number Format.");
            }
            catch (Exception ex) {
                System.out.println("Error.");
            }

            switch (closetInput) {
                case 1:
                    System.out.println("\n======== PUT YOUR TINFOIL HAT ON ========");
                    displayProducts();
                    break;

                case 2:
                    System.out.println("======== FIND THE THEORY THAT FITS ========");




                case 3:
                    break;
                default:
                    System.out.println("Please Choose Valid Option.\n");
            }
        }
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
