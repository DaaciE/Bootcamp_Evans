package org.example;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TheGoodAccount {
    public static final String ORANGE = "\u001B[38;5;208m";
    public static final String PINK = "\u001B[38;5;213m";
    public static final String PURPLE = "\u001B[35m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String BOLD = "\u001B[1m";
    public static final String RESET = "\u001B[0m";

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
        System.out.println(ORANGE + "           \\" + RESET + YELLOW + "  |"+ RESET + ORANGE + "  /" + RESET);
        System.out.println(YELLOW + "        ---" + RESET + ORANGE + "  ( )  " + RESET + YELLOW + "---" + RESET);
        System.out.println(YELLOW + "________" + RESET + BLUE + "THE GOOD ACCOUNT" + RESET + YELLOW + "________" + RESET);
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
                    System.out.println(YELLOW + "         \\  |  /" + RESET);
                    System.out.println(ORANGE + "       --- (☼) ---" + RESET);
                    System.out.println(YELLOW + "          / | \\" + RESET);
                    System.out.println(PINK + "   ~~~~~~~~~~~~~~~~~~~~" + RESET);

                    System.out.println(ORANGE + "✧ UNTIL THE NEXT AFTERLIFE ✧" + RESET);
                    System.out.println(PINK + "    \"Take it sleazy!\"" + RESET);
                    System.out.println(PURPLE + "    ☁ ⋆｡°✩ ☁ ✩°｡⋆ ☁" + RESET);
                    break;

                default:
                    System.out.println(ORANGE + "✧ OH, DIP! ✧" + RESET);
                    System.out.println(PINK + "☁ THAT WASN'T AN OPTION! ☁" + RESET);
                    System.out.println(PURPLE + "\"Wait, what are we doing again?\"" + RESET);

            }
        }
    }

    private static void addTransaction(String transactionType, Scanner scanner) {
        String descriptionInput = "";
        String vendorInput = "";
        double amount = 0.0;
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        try {
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
                System.out.println(ORANGE + "✧ OH, DIP! ✧" + RESET);
                System.out.println(PINK + "☁ THAT WASN'T AN OPTION! ☁" + RESET);
                System.out.println(PURPLE + "\"Wait, what are we doing again?\"" + RESET);
                return;
            }
            Transaction transaction = new Transaction(date, time, descriptionInput, vendorInput, amount);
            FileManager.writeTransaction(transaction);
        }
        catch (NumberFormatException ex){
            System.out.println(ORANGE + "✧ OH, DIP! ✧" + RESET);
            System.out.println(PINK + "☁ THAT WASN'T AN OPTION! ☁" + RESET);
            System.out.println(PURPLE + "\"Please enter a valid number for the amount.\"" + RESET);
        }
    }

    private static void displayLedger(Scanner scanner) {
        List<Transaction> transactions = FileManager.readTransaction();
        sortTransactions(transactions);
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("\nHi There! I'm Janet, How Can I Help You?");

        while (true) {
            System.out.println("\nYOUR LEDGER OPTIONS");
            System.out.println("A - All Transactions");
            System.out.println("D - Deposits");
            System.out.println("P - Payments");
            System.out.println("R - Reports");
            System.out.println("H - Home");
            String ledgerInput = scanner.nextLine().trim().toUpperCase();

            switch (ledgerInput) {
                case "A":
                    System.out.println("____________________________________________TRANSACTIONS____________________________________________");
                    System.out.printf("%-15s %-12s %-30s %-20s %10s%n",
                            "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
                    for (Transaction t : transactions) {
                        System.out.printf("%-15s %-12s %-30s %-20s %10.2f%n",
                                t.getDate(),
                                t.getTime().format(timeFormat),
                                t.getDescription(),
                                t.getVendor(),
                                t.getAmount());
                    }
                    break;

                case "D":
                    System.out.println("____________________________________________DEPOSITS____________________________________________");
                    System.out.printf("%-15s %-12s %-30s %-20s %10s%n",
                            "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
                    for(Transaction t : transactions){
                        if(t.getAmount() > 0) {
                            System.out.printf("%-15s %-12s %-30s %-20s %10.2f%n",
                                    t.getDate(),
                                    t.getTime().format(timeFormat),
                                    t.getDescription(),
                                    t.getVendor(),
                                    t.getAmount());
                        }
                    }
                    break;

                case "P":
                    System.out.println("____________________________________________PAYMENTS____________________________________________");
                    System.out.printf("%-15s %-12s %-30s %-20s %10s%n",
                            "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
                    for(Transaction t : transactions){
                        if(t.getAmount() < 0) {
                            System.out.printf("%-15s %-12s %-30s %-20s %10.2f%n",
                                    t.getDate(),
                                    t.getTime().format(timeFormat),
                                    t.getDescription(),
                                    t.getVendor(),
                                    t.getAmount());
                        }
                    }
                    break;

                case "R":
                    System.out.println(BLUE + "        *       .       *" + RESET);
                    System.out.println(PURPLE + "    .       ☾       ." + RESET);
                    System.out.println(BLUE + "         *      ." + RESET);

                    System.out.println(PURPLE + "✧ THE NUMBERS DON'T LIE ✧" + RESET);
                    System.out.println(BLUE + "\"Every financial decision has consequences.\"" + RESET);
                    System.out.println(PURPLE + "       ⋆｡°✩ ⋆｡°✩" + RESET);
                    displayReports(scanner);
                    break;

                case "H":
                    System.out.println("Wonderful choice! Returning you to the home screen.");
                    return;

                default:
                    System.out.println(ORANGE + "✧ OH, DIP! ✧" + RESET);
                    System.out.println(PINK + "☁ THAT WASN'T AN OPTION! ☁" + RESET);
                    System.out.println(PURPLE + "\"Wait, what are we doing again?\"" + RESET);
                    break;
            }

        }
    }

    private static void displayReports(Scanner scanner){
        List<Transaction> transactions = FileManager.readTransaction();
        sortTransactions(transactions);
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("\nWonderful choice! I've got that right here.");

        while (true){
            System.out.println("\nYOUR REPORT OPTIONS");
            System.out.println("1 - Month to Date");
            System.out.println("2 - Previous Month");
            System.out.println("3 - Year To Date");
            System.out.println("4 - Previous Year");
            System.out.println("5 - Search by Vendor");
            System.out.println("0 - Ledger Menu");
            String reportInput = scanner.nextLine().trim();

            switch (reportInput){

                case "1": {
                    System.out.println("\nWonderful choice! I've got that right here.\n");
                    System.out.println("____________________________________________MONTH TO DATE____________________________________________");

                LocalDate today = LocalDate.now();
                    LocalDate firstDay = today.withDayOfMonth(1);
                    filterByDate(transactions, firstDay, today);
                    System.out.println("");
                    break;
                }

                case "2": {
                    System.out.println("\nWonderful choice! I've got that right here.\n");
                    System.out.println("____________________________________________PREVIOUS MONTH____________________________________________");

                    LocalDate today = LocalDate.now();
                    LocalDate previousMonth = today.minusMonths(1);
                    LocalDate firstDay = previousMonth.withDayOfMonth(1);
                    LocalDate lastDay = previousMonth.withDayOfMonth(previousMonth.lengthOfMonth());

                    filterByDate(transactions, firstDay, lastDay);
                    System.out.println("");
                    break;
                }

                case "3": {
                    System.out.println("\nWonderful choice! I've got that right here.\n");
                    System.out.println("____________________________________________YEAR TO DATE____________________________________________");

                    LocalDate today = LocalDate.now();
                    LocalDate thisYear = today.withDayOfYear(1);

                    filterByDate(transactions, thisYear, today);
                    System.out.println("");
                    break;
                }

                case "4":{
                    System.out.println("\nWonderful choice! I've got that right here.\n");

                    System.out.println("____________________________________________PREVIOUS YEAR____________________________________________");

                    LocalDate today = LocalDate.now();
                    LocalDate previousYear = today.minusYears(1);
                    LocalDate firstDay = previousYear.withDayOfYear(1);
                    LocalDate lastDay = previousYear.withDayOfYear(previousYear.lengthOfYear());

                    filterByDate(transactions, firstDay, lastDay);
                    System.out.println("");
                    break;
                }

                case "5":
                    String vendorInput = "";

                    System.out.println("\nWonderful choice! I've got that right here.");
                    System.out.println("What Vendor Are You Looking For:");
                    vendorInput = scanner.nextLine();

                    /*to make sure the user input was being saved!
                    System.out.println("You searched for: [" + vendorInput + "]"); */

                    if (vendorInput.trim().isEmpty()){
                        System.out.println(ORANGE + "✧ OH, DIP! ✧" + RESET);
                        System.out.println(PINK + "☁ THAT WASN'T AN OPTION! ☁" + RESET);
                        System.out.println(PURPLE + "\"I Think You Need to Put Something In There\"" + RESET);
                    } else{
                        boolean vendorFound = false;

                        System.out.println("____________________________________________SEARCH BY VENDOR____________________________________________");
                        System.out.printf("%-15s %-12s %-30s %-20s %10s%n",
                                "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
                    for(Transaction t : transactions) {
                        if(t.getVendor().toLowerCase().contains(vendorInput.trim().toLowerCase())){
                            vendorFound = true;

                            System.out.printf("%-15s %-12s %-30s %-20s %10.2f%n",
                                    t.getDate(),
                                    t.getTime().format(timeFormat),
                                    t.getDescription(),
                                    t.getVendor(),
                                    t.getAmount());
                        }
                        }
                        if(!vendorFound) {
                            System.out.println("\nNo Transactions Found for that Vendor.");
                        }
                        }
                    break;

                case "0":
                    System.out.println("Not a Problem! I'm Happy to Help.\n");
                    return;

                default:
                    System.out.println(ORANGE + "✧ OH, DIP! ✧" + RESET);
                    System.out.println(PINK + "☁ THAT WASN'T AN OPTION! ☁" + RESET);
                    System.out.println(PURPLE + "\"Wait, what are we doing again?\"" + RESET);
                    break;
                        }

                    }

                }

    private static void filterByDate(List<Transaction> transactions, LocalDate startDate, LocalDate endDate){
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.printf("%-15s %-12s %-30s %-20s %10s%n",
                "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");

        for (Transaction t : transactions) {
            if(!t.getDate().isBefore(startDate) && !t.getDate().isAfter(endDate)) {
                System.out.printf("%-15s %-12s %-30s %-20s %10.2f%n",
                        t.getDate(),
                        t.getTime().format(timeFormat),
                        t.getDescription(),
                        t.getVendor(),
                        t.getAmount());
            }
        }
    }

    private static void sortTransactions(List<Transaction> transactions) {
        //sorting method.
        transactions.sort((t1,t2) -> {
            int dateComparison = t2.getDate().compareTo(t1.getDate());

            /* if the dates match, that equals 0, and puts the bigger date first
            if they don't match, it could be a positive or a negative, and will
             */

            if(dateComparison != 0) {
                return dateComparison;
            }
            /*
            if the dates = 0, meaning they match, it will move on to comparing the time
             */
            return t2.getTime().compareTo(t1.getTime());
        });
    }
            }



