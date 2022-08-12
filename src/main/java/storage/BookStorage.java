package storage;


import exception.AuthorNotFoundException;
import model.Author;
import model.Book;

import java.util.Scanner;

public class BookStorage {


    private static Author author = new Author();

    private static Scanner scanner = new Scanner(System.in);
    private static Book book = new Book();

    private Book[] array = new Book[10];
    private int size = -1;


    public void add(Book book) {
        if (size == array.length) {
            extend();
        }
        array[++size] = book;
    }


    public void print() {
        for (int i = 0; i < size + 1; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }


    private void extend() {
        if (size == array.length) {
            Book[] temp = new Book[array.length + 10];
            for (int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
    }

    public void printBooks() {
        for (int i = 0; i <= size; i++) {
            System.out.println(array[i].getTitle());

        }
    }

    public void PrintBooksByGenre(String authorName) {
        for (int i = 0; i <= size; i++) {
            if (array[i].getAuthorName().equals(authorName)) {
                System.out.println(array[i].getTitle());
            }
        }
    }

    public void PrintBooksByPriceRange(String genre) {
        for (int i = 0; i <= size; i++) {
            if (array[i].getGenre().equals(genre)) {
                System.out.println(array[i].getTitle());
            }
        }
    }

    public void booksByPriceRange(int price, int price1) {
        for (int i = 0; i <= size; i++) {
            if (array[i].getPrice() > price && array[i].getPrice() < price1) {
                System.out.println(array[i].getTitle());
            }

        }
    }

    public String printIndexAuthorName(int index) {
        if (index < 0 || index > size) {
            throw new AuthorNotFoundException(index + " not found");
        }
        return array[index].getAuthorName();
    }
}

