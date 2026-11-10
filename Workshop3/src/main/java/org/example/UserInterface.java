package org.example;

import java.util.Map;
import java.util.HashMap;
import java.util.*;

public class UserInterface {
    private List<Product> productList;
    private List<Product> cart = new ArrayList<>();

    public UserInterface(List<Product> productList) {
        this.productList = productList;
    }


    public void DisplayHomeScreen() {
        // Main menu
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("3")) {
            System.out.println("\n===== THEORIES =====");
            System.out.println("1) Our Closet ");
            System.out.println("2) CART");
            System.out.println("3) Exit");
            System.out.println("Enter Your Choice:");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    //Display clothing items and search through them
                    displayClosetMenu();
                    break;

                case "2":
                    // Cart menu
                displayCart(scanner);
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
            System.out.println("\n======== THE DETAILS BEHIND THE THEORY ========");
            System.out.println("1) OUR ENTIRE CLOSET ");
            System.out.println("2) SEARCH");
            System.out.println("3) Back to Closet");
            System.out.println("Enter Your Choice:");
            closetInput = scanner.nextLine();


            switch (closetInput) {
                case "1":
                    System.out.println("\n======== PUT YOUR TINFOIL HAT ON ========\n");
                    displayProducts();
                    promptAddToCart(scanner);
                    break;

                case "2":
                    String searchInput = "";
                    System.out.println("\n======== FIND THE THEORY THAT FITS ========");
                    System.out.printf("How would you like to search:");
                    System.out.println("Your options are: ");
                    System.out.println("1) Search by Name");
                    System.out.println("2) Search by Sku");
                    System.out.println("3) Search by Department");
                    System.out.println("4) Return to Closet");
                    System.out.println("Enter Your Choice:");
                    searchInput = scanner.nextLine();

                    switch (searchInput) {
                        case "1":
                            System.out.println("Enter Product Name:");
                            String clothingItem = scanner.nextLine().trim();
                            searchByName(productList, clothingItem);
                            promptAddToCart(scanner);
                            break;

                        case "2":
                            System.out.println("Enter Product SKU:");
                            String itemSku = scanner.nextLine().trim();
                            searchBySku(productList, itemSku);
                            promptAddToCart(scanner);
                            break;

                        case "3":
                            System.out.println("Enter Product Department:");
                            String itemDepartment = scanner.nextLine().trim();
                            searchByDepartment(productList, itemDepartment);
                            promptAddToCart(scanner);
                            break;

                        case "4":
                            System.out.println("Returning to the Closet...");
                            break;

                        default:
                            System.out.println("Please Input a Valid Option.");
                            break;
                    } break;

                case "3":
                    System.out.println("");
                    break;

                default:
                    System.out.println("Please Choose a Valid Option.\n");

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
        boolean found = false;

        for (Product product : productList) {
            if (product.getClothingItem().toLowerCase().contains(clothingItem.toLowerCase())) {
                found = true;

                System.out.println("");
                System.out.printf("%s| (%s) %s", product.getCategory(), product.getSku(), product.getClothingItem());
                System.out.println("");
            }
        }
        if (found) {
            System.out.println("YOUR FINDINGS, COLLECTED!\n");
        } else {
            System.out.println("FINDINGS DEBUNKED!\n");
        }
    }

    private void searchBySku(List<Product> productList, String sku) {
        // Search by SKU
        boolean found = false;

        for (Product product : productList) {
            if (product.getSku().toLowerCase().contains(sku.toLowerCase())) {
                found = true;
                System.out.println("");
                System.out.printf("%s| (%s) %s", product.getCategory(), product.getSku(), product.getClothingItem());
                System.out.println("");
            }
        }
        if (found) {
            System.out.println("YOUR FINDINGS, COLLECTED!\n");
        } else {
            System.out.println("FINDINGS DEBUNKED!\n");
        }
    }
    private void searchByDepartment(List<Product> productList, String category) {
        // Search by Department
        boolean found = false;

        for (Product product : productList) {
            if (product.getCategory().toLowerCase().contains(category.toLowerCase())) {
                found = true;
                System.out.println("");
                System.out.printf("%s| (%s) %s", product.getCategory(), product.getSku(), product.getClothingItem());
                System.out.println("");
            }
        }
        if (found) {
            System.out.println("YOUR FINDINGS, COLLECTED!\n");
        } else {
            System.out.println("FINDINGS DEBUNKED!\n");
        }
        }

    private void promptAddToCart(Scanner scanner) {

        while(true) {
            System.out.println("Enter a product SKU to add to cart, or press Enter to go back:");
            String sku = scanner.nextLine().trim();

            if (sku.isEmpty()) {
                break;
            } addToCart(sku);
        }
    }
    private void addToCart(String sku) {
        for (Product product : productList) {
            if (product.getSku().toLowerCase().contains(sku.toLowerCase())) {
                cart.add(product);
                System.out.println("ADDED TO YOUR CART!");
                return;
            }
        }
    }
    private void removeFromCart(String sku) {
        for (Product product : cart) {
            if (product.getSku().toLowerCase().contains(sku.toLowerCase())) {
                cart.remove(product);
                System.out.println("ITEM REMOVED!");
                return;
            }
        }System.out.println("ITEM NOT FOUND IN CART!");
    }

    private void displayCart(Scanner scanner){
        double cartTotal = 0;

        System.out.println("============YOUR CART============");
        System.out.println("1) View Cart");
        System.out.println("2) Checkout");
        System.out.println("3) Return Home");
        System.out.println("\nEnter Your Choice:");
        String cartInput = scanner.nextLine();

        switch (cartInput) {
        case "1":
             cartTotal = 0;

             Map<String, Integer> quantities = new HashMap<>();

            for( Product product : cart){
                String sku = product.getSku();
                int count = quantities.getOrDefault(sku, 0); //<< this means Find the current quantity, or use 0 if SKU isn't found
                quantities.put(sku, count + 1); // Increase the quantity by 1 and save it

                //System.out.printf("SKU:%s| %-25s $%5.2f%n",product.getSku(), product.getClothingItem(), product.getPrice());
                cartTotal += product.getPrice();
            }

            for(Product product : productList) {
                String sku = product.getSku();

                if (quantities.containsKey(sku)) {
                    int quantity = quantities.get(sku);

                    System.out.printf("SKU:%s| %-25s $%5.2f%n QTY: %d%n",
                            product.getSku(),
                            product.getClothingItem(),
                            product.getPrice(),
                            quantity);
                }
            }

            System.out.printf("\nTotal: %.2f",cartTotal);
            System.out.println(" ");

            while(true) {
                System.out.println("Enter a product SKU to remove from your cart, or press Enter to go back:");
                 cartInput = scanner.nextLine().trim();
                if (cartInput.isEmpty()) {
                break;
                    //"\\d{3}": \\d  represents any digit from 0–9
                    //{3} Requires exactly 3 digits
                    //.matches() - checks whether the entire String matches the pattern

                } if (!cartInput.matches("\\d{3}")) {
                    System.out.println("PLEASE ENTER A VALID SKU!");
                    continue;
                }
                removeFromCart(cartInput);
            }
            break;

            case "2":

        }

    }

}






