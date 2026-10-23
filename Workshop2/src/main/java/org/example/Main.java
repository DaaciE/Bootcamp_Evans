package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] book = new Book[20];

        book[0] = new Book(1, "978-0451524935", "1984", false, "");
        book[1] = new Book(2, "978-0061120084", "To Kill a Mockingbird", true, "John Smith");
        book[2] = new Book(3, "978-0743273565", "The Great Gatsby", false, "");
        book[3] = new Book(4, "978-0141439518", "Pride and Prejudice", true, "Sarah Johnson");
        book[4] = new Book(5, "978-0316769488", "The Catcher in the Rye", false, "");
        book[5] = new Book(6, "978-0544003415", "The Lord of the Rings", true, "Michael Brown");
        book[6] = new Book(7, "978-0062315007", "The Alchemist", false, "");
        book[7] = new Book(8, "978-0307474278", "The Girl with the Dragon Tattoo", true, "Emily Davis");
        book[8] = new Book(9, "978-0743477109", "Romeo and Juliet", false, "");
        book[9] = new Book(10, "978-1503280786", "Moby-Dick", true, "David Wilson");
        book[10] = new Book(11, "978-1451673319", "Fahrenheit 451", false, "");
        book[11] = new Book(12, "978-0140449136", "The Odyssey", true, "Jessica Miller");
        book[12] = new Book(13, "978-0307277671", "The Road", false, "");
        book[13] = new Book(14, "978-0140177398", "Of Mice and Men", true, "Christopher Moore");
        book[14] = new Book(15, "978-0439064873", "Harry Potter and the Chamber of Secrets", false, "");
        book[15] = new Book(16, "978-0553380163", "A Brief History of Time", true, "Amanda Taylor");
        book[16] = new Book(17, "978-0060850524", "Brave New World", false, "");
        book[17] = new Book(18, "978-0140283334", "The Kite Runner", true, "Daniel Anderson");
        book[18] = new Book(19, "978-0374533557", "The Stranger", false, "");
        book[19] = new Book(20, "978-0307387899", "The Road Less Traveled", true, "Olivia Thomas");







    }
}