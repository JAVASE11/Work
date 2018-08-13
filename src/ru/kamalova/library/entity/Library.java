package ru.kamalova.library.entity;

import java.util.List;

public interface Library {
    void addBook(Book book);


    void removeBook(Book book);


    Book findBookByTitle(String name);


    List<Book> findByAuthor(String author);

    List<Book> findAllBooks();

}
