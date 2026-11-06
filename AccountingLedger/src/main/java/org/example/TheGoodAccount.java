package org.example;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TheGoodAccount {
    //COLOURS
    public static final String ORANGE = "\u001B[38;5;208m";
    public static final String PINK = "\u001B[38;5;213m";
    public static final String PURPLE = "\u001B[35m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PASTEL_PINK = "\u001B[38;2;245;180;208m";
    public static final String PEACH = "\u001B[38;2;255;184;140m";
    public static final String BUTTER_YELLOW = "\u001B[38;2;255;217;142m";
    public static final String LAVENDER = "\u001B[38;2;205;180;246m";
    public static final String BABY_BLUE = "\u001B[38;2;169;216;243m";
    public static final String MINT_GREEN = "\u001B[38;2;184;230;208m";
    public static final String ROSEWATER = "\u001B[38;2;250;218;221m";
    public static final String COTTON_CANDY = "\u001B[38;2;255;204;229m";
    public static final String SOFT_CORAL = "\u001B[38;2;255;181;167m";
    public static final String APRICOT = "\u001B[38;2;255;209;169m";
    public static final String VANILLA_CREAM = "\u001B[38;2;255;240;194m";
    public static final String LEMON_CHIFFON = "\u001B[38;2;255;250;205m";
    public static final String LILAC = "\u001B[38;2;216;180;226m";
    public static final String PERIWINKLE = "\u001B[38;2;191;203;250m";
    public static final String POWDER_BLUE = "\u001B[38;2;176;224;230m";
    public static final String SEAFOAM = "\u001B[38;2;184;232;223m";
    public static final String PISTACHIO = "\u001B[38;2;212;232;181m";
    public static final String SAGE_GREEN = "\u001B[38;2;201;216;190m";
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

        System.out.println(BUTTER_YELLOW + "            \\  |  /" + RESET);
        System.out.println(PEACH + "          --- (☼) ---" + RESET);
        System.out.println(BUTTER_YELLOW + "             / | \\" + RESET);
        System.out.println("     .--.                 .--.");
        System.out.println("  .-(    ).            .-(    ).");
        System.out.println(" (___.__)__)          (___.__)__)");
        System.out.println();

        while (!userInput.equals("X")) {
            System.out.println(PEACH + "       ✧ THE GOOD ACCOUNT ✧" + RESET);
            System.out.println(LAVENDER + "   Everything is fine. Probably." + RESET);
            Thread.sleep(500);
            System.out.println("\nWelcome to the Good Account!");
            System.out.println("How Can I Help You?\n");
            System.out.println("YOUR ACCOUNT OPTIONS");
            System.out.println(BUTTER_YELLOW + "[D] Add Deposit" + RESET);
            System.out.println(PASTEL_PINK + "[P] Make Payment" + RESET);
            System.out.println(LAVENDER + "[L] View Ledger" + RESET);
            System.out.println(BABY_BLUE + "[X] Exit" + RESET);
            System.out.println();
            System.out.println(BABY_BLUE + "Enter Your Choice:" + RESET);
            userInput = scanner.nextLine().trim().toUpperCase();

            switch (userInput) {
                case "D":
                    System.out.println(BUTTER_YELLOW + "         \\  |  /" + RESET);
                    System.out.println(PEACH + "       --- (☼) ---" + RESET);
                    System.out.println(BUTTER_YELLOW + "          / | \\" + RESET);

                    System.out.println(PASTEL_PINK + "☁ ✧ A GOOD THING JUST CAME IN! ✧ ☁" + RESET);
                    System.out.println(BUTTER_YELLOW + "\"Darling, how wonderfully prosperous!\"" + RESET);
                    addTransaction(userInput, scanner);
                    break;

                case "P":
                    System.out.println(PASTEL_PINK + "      .--.        .--." + RESET);
                    System.out.println(PASTEL_PINK + "   .-(    ).   .-(    )." + RESET);
                    System.out.println(LAVENDER + "  (___.__)__) (___.__)__)" + RESET);

                    System.out.println(PEACH + "✧ OH, FORK! MONEY'S LEAVING! ✧" + RESET);
                    System.out.println(PASTEL_PINK + "\"Okay, but did we really need that?\"\n" + RESET);
                    addTransaction(userInput, scanner);
                    break;

                case "L":
                    System.out.println(LAVENDER + "     .--.          .--." + RESET);
                    System.out.println(PASTEL_PINK + "  .-(    ).     .-(    )." + RESET);
                    System.out.println(LAVENDER + " (___.__)__)   (___.__)__)" + RESET);

                    System.out.println(PASTEL_PINK + "✧ WELCOME TO THE LEDGER VOID ✧" + RESET);
                    System.out.println(BABY_BLUE + "\"Hi there! I've got your records right here!\"" + RESET);
                    displayLedger(scanner);
                    break;

                case "X":
                    System.out.println(BUTTER_YELLOW + "         \\  |  /" + RESET);
                    System.out.println(PEACH + "       --- (☼) ---" + RESET);
                    System.out.println(BUTTER_YELLOW + "          / | \\" + RESET);
                    System.out.println(PINK + "   ~~~~~~~~~~~~~~~~~~~~" + RESET);

                    System.out.println(PEACH + "✧ UNTIL THE NEXT AFTERLIFE ✧" + RESET);
                    System.out.println(PASTEL_PINK + "    \"Take it sleazy!\"" + RESET);
                    break;

                default:
                    System.out.println(PEACH + "✧ OH, DIP! ✧" + RESET);
                    System.out.println(PASTEL_PINK + "☁ THAT WASN'T AN OPTION! ☁" + RESET);
                    System.out.println(LAVENDER + "\"Wait, what are we doing again?\"" + RESET);

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
            System.out.println(MINT_GREEN + "[A] All Transactions" + RESET);
            System.out.println(BUTTER_YELLOW + "[D] Deposits" + RESET);
            System.out.println(PASTEL_PINK + "[P] Payments" + RESET);
            System.out.println(LAVENDER + "[R] Reports" + RESET);
            System.out.println(BABY_BLUE + "[H] Home" + RESET);
            System.out.println();
            System.out.println(BABY_BLUE + "Enter Your Choice:" + RESET);
            String ledgerInput = scanner.nextLine().trim().toUpperCase();

            switch (ledgerInput) {
                case "A":
                    System.out.println(MINT_GREEN +"____________________________________________TRANSACTIONS____________________________________________"+ RESET);
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
                    System.out.println(BUTTER_YELLOW + "____________________________________________DEPOSITS____________________________________________"+ RESET);
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
                    System.out.println(PASTEL_PINK + "____________________________________________PAYMENTS____________________________________________"+ RESET);
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
                    System.out.println("Wonderful choice! Returning you to the home screen.\n");
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
            System.out.println(MINT_GREEN + "[1] Month to Date");
            System.out.println(BUTTER_YELLOW + "[2] Previous Month"+ RESET);
            System.out.println(PASTEL_PINK + "[3] Year To Date"+ RESET);
            System.out.println(LAVENDER + "[4] Previous Year"+ RESET);
            System.out.println(PEACH + "[5] Search by Vendor"+ RESET);
            System.out.println(PISTACHIO + "[6] Custom Search" + RESET);
            System.out.println(BABY_BLUE + "[0] Ledger Menu" + RESET);
            System.out.println();
            System.out.println(BABY_BLUE + "Enter Your Choice:" + RESET);
            String reportInput = scanner.nextLine().trim();

            switch (reportInput){

                case "1": {
                    System.out.println("\nWonderful choice! I've got that right here.\n");
                    System.out.println(MINT_GREEN + "____________________________________________MONTH TO DATE____________________________________________"+ RESET);

                LocalDate today = LocalDate.now();
                    LocalDate firstDay = today.withDayOfMonth(1);
                    filterByDate(transactions, firstDay, today);
                    System.out.println(" ");
                    break;
                }

                case "2": {
                    System.out.println("\nWonderful choice! I've got that right here.\n");
                    System.out.println(BUTTER_YELLOW + "____________________________________________PREVIOUS MONTH____________________________________________"+ RESET);

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
                    System.out.println(PASTEL_PINK + "____________________________________________YEAR TO DATE____________________________________________"+ RESET);

                    LocalDate today = LocalDate.now();
                    LocalDate thisYear = today.withDayOfYear(1);

                    filterByDate(transactions, thisYear, today);
                    System.out.println("");
                    break;
                }

                case "4":{
                    System.out.println("\nWonderful choice! I've got that right here.\n");

                    System.out.println(LAVENDER + "____________________________________________PREVIOUS YEAR____________________________________________"+ RESET);

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

                        System.out.println(PEACH + "____________________________________________SEARCH BY VENDOR____________________________________________"+ RESET);
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

                case "6" :
                    System.out.println();
                    System.out.println(VANILLA_CREAM + "✧ UNDER CONSTRUCTION ✧" + RESET);
                    System.out.println(PASTEL_PINK + "\"Fun fact! This feature doesn't exist yet. Isn't that exciting?\"" + RESET);
                    System.out.println(LAVENDER + "- Janet, probably" + RESET);
                    System.out.println();
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



