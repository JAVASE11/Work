package ru.kamalova.library.service;


import ru.kamalova.library.entity.Book;
import ru.kamalova.library.entity.Library;

import java.util.List;

public class LibraryService implements Service {

    private Library library;

    @Override
    public List<Book> findByAuthor(String author) {
        return library.findByAuthor(author);
    }

    @Override
    public List<Book> findAllBooks() {
        return library.findAllBooks();
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public void addBook(Book book) {
        library.addBook(book);
    }

    @Override
    public void removeBook(Book book) {
        library.removeBook(book);
    }

    @Override
    public Book findByTitle(String title) {
        return library.findBookByTitle(title);
    }
}
