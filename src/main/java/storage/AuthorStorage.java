package storage;

import model.Author;

import java.util.Scanner;

public class AuthorStorage {
    Scanner scanner=new Scanner(System.in);

    private static Author author = new Author();

    private Author[] array = new Author[10];
    private int size = -1;


    public void add(Author author) {
        if (size == array.length) {
            extend();
        }
        array[++size] = author;
    }


    public void print() {
        for (int i = 0; i < size + 1; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }


    private void extend() {
        if (size == array.length) {
            Author[] temp = new Author[array.length + 10];
            for (int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
    }

    public Author getAuthorByIndex(int indexName) {
        if (indexName < 0 || indexName >= size) {
            return null;
        }
        return array[indexName];
    }
    public void printAuthorByEmail() {
        for (int i = 0; i <= size; i++) {
            if (!array[i].getEmail().equals(scanner.nextLine())) {
                System.out.println("Invalid commands");
                printAuthorByEmail();
            }else {
                System.out.println(array[i].getName());
            }
        }
    }

    public int getSize() {
        return size + 1;
    }


}
