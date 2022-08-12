package commands;

public interface Commands {

    int EXIT = 0;
    int ADD_BOOK = 1;
    int ADD_PRINT_ALL_BOOKS = 2;
    int ADD_PRINT_BOOKS_AUTHOR_NAME = 3;
    int ADD_PRINT_BOOKS_BY_GENRE = 4;
    int ADD_PRINT_BOOKS_BY_PRICE_RANGE = 5;
    int PRINT_ARRAY = 6;
    int ADD_AUTHOR = 7;
    int PRINT_ARRAY_AUTHOR = 8;
    int PRINT_AUTHOR_BY_EMAIL = 9;
    int PRINT_INDEX_AUTHOR_NAME = 10;

   static void printCommands(){
       System.out.println("please input " + EXIT + " for exit");
       System.out.println("please input " + ADD_BOOK + " for add book");
       System.out.println("please input " + ADD_PRINT_ALL_BOOKS + " for print all books");
       System.out.println("please input " + ADD_PRINT_BOOKS_AUTHOR_NAME + " for print Books by AuthorName");
       System.out.println("please input " + ADD_PRINT_BOOKS_BY_GENRE + " for print Books by Genre");
       System.out.println("please input " + ADD_PRINT_BOOKS_BY_PRICE_RANGE + " for print books by price range");
       System.out.println("please input " + PRINT_ARRAY + " for print array");
       System.out.println("please input " + ADD_AUTHOR + " for add author");
       System.out.println("please input " + PRINT_ARRAY_AUTHOR + " for print authorArray");
       System.out.println("please input " + PRINT_AUTHOR_BY_EMAIL + " for print authorEmail");
       System.out.println("please input " + PRINT_INDEX_AUTHOR_NAME + " for print index authorName");
    }
}
