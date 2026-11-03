package org.example;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TheGoodAccount {
    public static void main(String[] args) throws InterruptedException {
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



        System.out.println("             .        *");
        System.out.println("        .        .");
        System.out.println("           \\  |  /");
        System.out.println("        ---  ( )  ---");
        System.out.println("________THE GOOD ACCOUNT________");
        System.out.println("Your finances are in good hands\n");
        Thread.sleep(500);

        while (!userInput.equals("X")) {
            System.out.println("\nWelcome to the Good Account!");
            System.out.println("How Can I Help You?\n");
            System.out.println("YOUR ACCOUNT OPTIONS");
            System.out.println("D - Add Deposit");
            System.out.println("P - Make Payment");
            System.out.println("L - View Ledger");
            System.out.println("X = Exit");

            userInput = scanner.nextLine().trim().toUpperCase();

            switch (userInput) {
                case "D":
                    addTransaction(userInput, scanner);
                    break;

                case "P":
                    addTransaction(userInput, scanner);
                    break;

                case "L":
                    displayLedger(scanner);
                    break;

                case "X":
                    System.out.println("Until next time, remember: everything is fine. Probably.");
                    break;

                default:
                    System.out.println("Oh, fork! That's not an option.");

            }
        }
    }

    private static void addTransaction(String transactionType, Scanner scanner) {
        String descriptionInput = "";
        String vendorInput = "";
        double amount = 0.0;
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println("Enter Description");
        descriptionInput = scanner.nextLine();
        System.out.println("Vendor:");
        vendorInput = scanner.nextLine();
        System.out.println("Amount:");
        amount = Double.parseDouble(scanner.nextLine());

        if (transactionType.equals("D")) {
            //Math.abs makes the number positive, in case the user accidentally makes the number negative
            amount = Math.abs(amount);
            System.out.println("A Good Thing Just Came In!");

        } else if (transactionType.equals("P")) {
            amount = -Math.abs(amount);
            System.out.println("A Little Goodness Has Left the Building!");

        } else {
            System.out.println("Oh, fork! That's not an option.");
            return;
        }
        Transaction transaction = new Transaction(date, time, descriptionInput, vendorInput, amount);
        FileManager.writeTransaction(transaction);
    }

    private static void displayLedger(Scanner scanner) {
        List<Transaction> transactions = FileManager.readTransaction();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("\nHi There! I'm Janet, How Can I Help You?");

        while (true) {
            System.out.println("YOUR LEDGER OPTIONS");
            System.out.println("A - All Transactions");
            System.out.println("D - Deposits");
            System.out.println("P - Payments");
            System.out.println("R - Reports");
            System.out.println("H = Home");
            String ledgerInput = scanner.nextLine().trim().toUpperCase();

            switch (ledgerInput) {
                case "A":
                    System.out.println("______________________TRANSACTIONS______________________\n");
                    for (Transaction t : transactions) {
                        System.out.printf("%s | %s | %s | %s | %.2f%n",
                                t.getDate(),
                                t.getTime().format(timeFormat),
                                t.getDescription(),
                                t.getVendor(),
                                t.getAmount());
                    }
                    break;

                case "D":
                    break;

                case "P":
                    break;

                case "R":
                    displayReports(scanner);
                    break;

                case "H":
                    System.out.println("Wonderful choice! Returning you to the home screen.");
                    return;

                default:
                    System.out.println("Oh, fork! That's not an option.");
                    break;
            }

        }
    }

    private static void displayReports(Scanner scanner){
        List<Transaction> transactions = FileManager.readTransaction();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("\nWonderful choice! I've got that right here.");

        while (true){
            System.out.println("YOUR REPORT OPTIONS");
            System.out.println("1 - Month to Date");
            System.out.println("2 - Previous Month");
            System.out.println("3 - Year To Date");
            System.out.println("4 - Previous Year");
            System.out.println("5 - Search by Vendor");
            System.out.println("0 - Ledger Menu");
            String reportInput = scanner.nextLine().trim();

            switch (reportInput){

                case "1":
                    System.out.println("\nWonderful choice! I've got that right here.");
                    break;

                case "2":
                    System.out.println("\nWonderful choice! I've got that right here.");
                    break;

                case "3":
                    System.out.println("\nWonderful choice! I've got that right here.");
                    break;

                case "4":
                    System.out.println("\nWonderful choice! I've got that right here.");
                    break;

                case "5":
                    System.out.println("\nWonderful choice! I've got that right here.");
                    break;

                case "0":
                    System.out.println("Not a Problem! I'm Happy to Help.\n");
                    return;

                default:
                    System.out.println("Oh, fork! That's not an option.");
                    break;
                        }

                    }

                }

            }



