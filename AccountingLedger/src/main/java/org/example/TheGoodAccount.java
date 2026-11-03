package org.example;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheGoodAccount {
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
        String userInput = "";


        System.out.println("________THE GOOD ACCOUNT________");
        System.out.println("Your finances are in good hands\n");
        Thread.sleep(1000);

        while(!userInput.equals("X")){
            System.out.println("\nWelcome to the Good Account!");
            System.out.println("Where every transaction count. Literally\n");
            System.out.println("YOUR ACCOUNT OPTIONS");
            System.out.println("D - Add Deposit");
            System.out.println("P - Make Payment");
            System.out.println("L - View Ledger");
            System.out.println("X = Exit\n");

            userInput = scanner.nextLine().toUpperCase();

            switch (userInput){
                case "D":
                    addTransaction(userInput, scanner);
                    break;

                case "P":
                    addTransaction(userInput, scanner);
                    break;

                case "L":


                case "X":
                    System.out.println("Take it sleazy!");
                    break;

                default:
                    System.out.println("Oh, fork! That's not an option.");

            }
        }
    }

    private static void addTransaction(String transactionType, Scanner scanner) {
        String descriptionInput = "";
        String  vendorInput = "";
        double amount = 0.0;
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println("Enter Description");
        descriptionInput = scanner.nextLine();
        System.out.println("Vendor:");
        vendorInput = scanner.nextLine();
        System.out.println("Amount:");
        amount =  Double.parseDouble(scanner.nextLine());

        if (transactionType.equals("D")){
            //Math.abs makes the number positive, in case the user accidentally makes the number negative
             amount = Math.abs(amount);
            System.out.println("A Good Thing Just Came In!");

        } else if(transactionType.equals("P")) {
             amount = -Math.abs(amount);
            System.out.println("A Bad Thing Just Came In!");

        } else {
            System.out.println("Oh, fork! That's not an option.");
            return;
        }
        Transaction transaction = new Transaction(date, time, descriptionInput, vendorInput, amount);
        FileManager.writeTransaction(transaction);
    }
}