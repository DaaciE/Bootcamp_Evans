package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class FileManager {
    public static List<Product> readProducts() {
        List<Product> productList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("src/main/resources/clothing_products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String row;
            bufferedReader.readLine();
            while ((row = bufferedReader.readLine()) != null) {
                String[] brokenUpRow = row.split("\\|");
                String sku = brokenUpRow[0]; //change to an integer
                String clothingItem = brokenUpRow[1];
                double price = Double.parseDouble(brokenUpRow[2]);
                String category = brokenUpRow[3];

                Product product = new Product(sku, clothingItem, price, category);

                productList.add(product);
            }

        } catch (IOException ex) {
            System.out.println("Trouble reading file. Check your file.");
            //ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("...");
            //ex.printStackTrace();
        }
        return productList;
    }

    public static void writeProduct(Product product) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = String.format("%s|%s|%.2f|%s",
                    product.getSku(),
                    product.getClothingItem(),
                    product.getPrice(),
                    product.getCategory());

            bufferedWriter.newLine();
            bufferedWriter.write(line);

            bufferedWriter.close();

            System.out.println("Write Successful!");
        }

        catch (InputMismatchException ex){
            System.out.println("Invalid Choice Option.");
        }
        catch (IOException ex) {
            System.out.println("Could not write to the file.");
        } catch (Exception ex) {
            System.out.println("Error when handling data.");
        }
    }
}
