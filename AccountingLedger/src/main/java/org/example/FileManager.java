package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class FileManager {
    public static List<Transaction> readTransaction() {
        List<Transaction> transactionList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int lineNumber = 0;
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                lineNumber++;
            try {
                String[] brokenUpRow = row.split("\\|");
                LocalDate date = LocalDate.parse(brokenUpRow[0]); //change to an integer
                LocalTime time = LocalTime.parse(brokenUpRow[1]);
                String description = brokenUpRow[2];
                String vendor = brokenUpRow[3];
                double amount = Double.parseDouble(brokenUpRow[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);

                transactionList.add(transaction);
            } catch (Exception ex){
                System.out.println("Error on line " + lineNumber + ": incorrectly formatted row.");
            }
            }

        } catch (IOException ex) {
            System.out.println("Trouble reading file. Check your file.");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("An unexpected error occurred while reading transactions.");
            ex.printStackTrace();
        }
        return transactionList;
    }

    public static void writeTransaction(Transaction transaction) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
            String line = String.format("%s|%s|%s|%s|%.2f",
                    transaction.getDate(),
                    transaction.getTime().format(timeFormat),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());

            bufferedWriter.write(line);
            bufferedWriter.newLine();

            bufferedWriter.close();

            System.out.println("Transaction Updated!");
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
