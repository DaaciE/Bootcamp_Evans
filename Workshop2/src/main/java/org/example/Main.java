package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Book[] book = new Book[20];

        book[0] = new Book(3301, "978-0451524935", "1984", false, "");
        book[1] = new Book(3302, "978-0061120084", "To Kill a Mockingbird", true, "John Smith");
        book[2] = new Book(3303, "978-0743273565", "The Great Gatsby", false, "");
        book[3] = new Book(3304, "978-0141439518", "Pride and Prejudice", true, "Sarah Johnson");
        book[4] = new Book(3305, "978-0316769488", "The Catcher in the Rye", false, "");
        book[5] = new Book(3306, "978-0544003415", "The Lord of the Rings", true, "Michael Brown");
        book[6] = new Book(3307, "978-0062315007", "The Alchemist", false, "");
        book[7] = new Book(3308, "978-0307474278", "The Girl with the Dragon Tattoo", true, "Emily Davis");
        book[8] = new Book(3309, "978-0743477109", "Romeo and Juliet", false, "");
        book[9] = new Book(3310, "978-1503280786", "Moby-Dick", true, "David Wilson");
        book[10] = new Book(3311, "978-1451673319", "Fahrenheit 451", false, "");
        book[11] = new Book(3312, "978-0140449136", "The Odyssey", true, "Jessica Miller");
        book[12] = new Book(3313, "978-0307277671", "The Road", false, "");
        book[13] = new Book(3314, "978-0140177398", "Of Mice and Men", true, "Christopher Moore");
        book[14] = new Book(3315, "978-0439064873", "Harry Potter and the Chamber of Secrets", false, "");
        book[15] = new Book(3316, "978-0553380163", "A Brief History of Time", true, "Amanda Taylor");
        book[16] = new Book(3317, "978-0060850524", "Brave New World", false, "");
        book[17] = new Book(3318, "978-0140283334", "The Kite Runner", true, "Daniel Anderson");
        book[18] = new Book(3319, "978-0374533557", "The Stranger", false, "");
        book[19] = new Book(3320, "978-0307387899", "The Road Less Traveled", true, "Olivia Thomas");

        //MENU START
        int choice = 0;
        System.out.println("\n~~~~~~~~~ Davia's Good Reads ~~~~~~~~~\n");

        while (true) {
            Thread.sleep(1000);
            System.out.println("\n~~~  MAIN MENU  ~~~\n");
            Thread.sleep(1000);
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books.");
            System.out.println("3. Exit.\n");
            System.out.println("Where Would You Like To Go?");
            choice = scanner.nextInt();

            //CHOICE 1:
            if (choice == 1) {

                for (int i = 0; i < book.length; i++) {

                    if (book[i].getIsCheckedOut() == false) {
                        System.out.println("");
                        System.out.println("ID: " + book[i].getId() + ", " + "ISBN: " + book[i].getIsbn() + ", TITLE: " + book[i].getTitle());
                    }

                }
                //Checking out BOOK
                int bookIdChoice = 0;

                System.out.println("\nAnything tickle your fannnnnnncy?");
                System.out.println("If so, Enter Book ID to Check Out");
                bookIdChoice = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < book.length; i++) {
                    //IF ID MATCHES:
                    if (bookIdChoice == 0){
                        System.out.println("See You Next Time!");
                        break;
                    }

                    else if (book[i].getId() == bookIdChoice) {
                        System.out.println("Whose the Reader?");
                        String fullName = scanner.nextLine();

                        book[i].checkOut(fullName);
                        System.out.println("\nYayyy! You did it");
                        System.out.println("Enjoy " + book[i].getTitle() + ", " + fullName);
                    }



                }
                //CHOICE 2

                if (choice == 2) {
                    for (int i = 0; i < book.length; i++) {

                        if (book[i].getIsCheckedOut() == true) {
                            System.out.println("");
                            System.out.println("ID: " + book[i].getId() + ", " + "ISBN: " + book[i].getIsbn() + ", TITLE: " + book[i].getTitle());
                            System.out.println("Checked out by, " + book[i].getCheckedOutTo());
                        }
                    }

                }


                }

            //CHOICE 3
            if (choice == 3) {
                System.out.println("See you soon!");
                break;
            }
            }


        }

    }