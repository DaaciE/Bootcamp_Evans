package org.example;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException  {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        /*TEST 1 READING FILES
        List<Transaction> transactions = FileManager.readTransaction();
        for(Transaction t : transactions) {
            System.out.printf("%s | %s | %s | %s | %.2f%n",
                    t.getDate(),
                    t.getTime().format(timeFormat),
                    t.getDescription(),
                    t.getVendor(),
                    t.getAmount());
        }
        //TEST 2 WRITING/SAVING FILES
        Transaction test = new Transaction(
                LocalDate.now(),
                LocalTime.now().truncatedTo(ChronoUnit.SECONDS),
                "test entry",
                "test vendor",
                -80.00);

        FileManager.writeTransaction(test);*/

        System.out.println("________THE GOOD ACCOUNT________");
        System.out.println("Your finances are in good hands\n");
        Thread.sleep(1000);

        System.out.println("\nWelcome to the Good Account!");
        System.out.println("Where every transaction count. Literally\n");
        System.out.println("YOUR ACCOUNT OPTIONS");
        System.out.println("D - Add Deposit");
        System.out.println("P - Make Payment");
        System.out.println("L - View Ledger");
        System.out.println("X = Exit");


    }
}