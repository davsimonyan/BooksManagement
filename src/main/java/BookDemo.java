import commands.Commands;
import exception.AuthorNotFoundException;
import model.Author;
import model.Book;
import storage.AuthorStorage;
import storage.BookStorage;

import java.util.Scanner;

public class BookDemo implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();
    private static Author author = new Author();

    public static void main(String[] args) {
        initData();

        System.out.println("Pleas input login and password");
        commands(scanner.nextLine(), scanner.nextLine());
    }

    private static void initData() {
        bookStorage.add(new Book("Vardananq", "Derenik Demirjyan", 450, 6, "history"));
        bookStorage.add(new Book("Samvel", "Raffi", 400, 4, "history"));
        bookStorage.add(new Book("Romeo & Juliet", "William Shakespeare", 750.50, 5, "drama"));

        authorStorage.add(new Author("Poxos", "Poxosyan", "poxos@mail.ru", "Male"));
        authorStorage.add(new Author("Martiros", "Martirosyan", "martiros@mail.ru", "Male"));
        authorStorage.add(new Author("Malena", "Maloyan", "malena@mail.ru", "Female"));
    }

    private static void addBook() {
        System.out.println("Please input books title");
        String title = scanner.nextLine();
        System.out.println("Please input author name");
        String authorName = scanner.nextLine();
        System.out.println("Please input price ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input count");
        String countStr = scanner.nextLine();
        System.out.println("Please input genre");
        String genre = scanner.nextLine();

        int count = Integer.parseInt(countStr);
        Book book = new Book(title, authorName, price, count, genre);
        bookStorage.add(book);
    }


    private static void addAuthor() {
        System.out.println("Please input author name");
        String name = scanner.nextLine();
        System.out.println("Please input author surname");
        String surname = scanner.nextLine();
        System.out.println("Please input author email");
        String email = scanner.nextLine();
        System.out.println("Please input gender");
        String gender = genderAuthor();

        Author author = new Author(name, surname, email, gender);
        authorStorage.add(author);
    }

    private static String genderAuthor() {

        authorStorage.print();
        System.out.println("1 Male | 2 Female");
        int index = Integer.parseInt(scanner.nextLine());
        if (index != 1 && index != 2) {
            System.out.println("Invalid commands");
            genderAuthor();
        } else if (index == 1) {
            author.setGender("Male");
        } else {
            author.setGender("Female");
        }
        return author.getGender();
    }

    private static void commands(String login, String password) {
        if (!login.equals("admin") || !password.equals("123456")) {
            System.err.println("login or password is wrong");
            System.out.println("Pleas input login and password");
            commands(scanner.nextLine(), scanner.nextLine());
        } else {
            boolean run = true;
            while (run) {
                Commands.printCommands();
                int command;
                try {
                    command = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    command = -1;
                }

                switch (command) {
                    case EXIT:
                        run = false;
                        break;
                    case ADD_BOOK:
                        addBook();
                        break;
                    case ADD_PRINT_ALL_BOOKS:
                        bookStorage.printBooks();
                        break;
                    case ADD_PRINT_BOOKS_AUTHOR_NAME:
                        String authorName = scanner.nextLine();
                        bookStorage.PrintBooksByGenre(authorName);
                        break;
                    case ADD_PRINT_BOOKS_BY_GENRE:
                        String genre = scanner.nextLine();
                        bookStorage.PrintBooksByPriceRange(genre);
                        break;
                    case ADD_PRINT_BOOKS_BY_PRICE_RANGE:
                        try {
                            int price = Integer.parseInt(scanner.nextLine());
                            int price1 = Integer.parseInt(scanner.nextLine());
                            bookStorage.booksByPriceRange(price, price1);
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid command");
                        }

                        break;
                    case PRINT_ARRAY:
                        bookStorage.print();
                        break;
                    case ADD_AUTHOR:
                        addAuthor();
                        break;
                    case PRINT_ARRAY_AUTHOR:
                        authorStorage.print();
                        break;
                    case PRINT_AUTHOR_BY_EMAIL:
                        authorStorage.printAuthorByEmail();
                        break;
                    case PRINT_INDEX_AUTHOR_NAME:
                        int index;
                        try {
                            System.out.println("Please input index author");
                            index = Integer.parseInt(scanner.nextLine());
                            System.out.println(bookStorage.printIndexAuthorName(index));
                        } catch (AuthorNotFoundException | NumberFormatException e) {
                            System.err.println("Please choose correct number or index!!!");
                        }
                        break;
                    default:
                        System.err.println("Invalid command");
                }
            }
        }

    }
}




