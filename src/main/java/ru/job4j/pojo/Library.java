package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Antifragile", 450);
        Book book2 = new Book("Blue Ocean Strategy", 320);
        Book book3 = new Book("The black Swen", 860);
        Book book4 = new Book("Clean code", 0);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        System.out.println("Initial list of books:");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getNumberOfpages());
        }

        System.out.println("\nSwapping places between book[0] and book[3]");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        System.out.println("Updated list after swapping:");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getNumberOfpages());
        }

        System.out.println("\nSearching for 'Clean code':");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getNumberOfpages());
            }
        }
    }
}
