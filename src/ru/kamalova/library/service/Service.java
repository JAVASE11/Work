package ru.kamalova.library.service;


import ru.kamalova.library.entity.Book;

import java.util.List;

public interface Service {

    void addBook(Book book);

    void removeBook(Book book);

    Book findByTitle(String param);

    List<Book> findByAuthor(String author);

    List<Book> findAllBooks();

}
