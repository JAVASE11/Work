package ru.kamalova.library.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LibraryFiction implements Library {

    private List<Book> books;

    public LibraryFiction() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        System.out.println("Ищем и удаляем: " + book);
        String res;
        res = books.remove(book) ? "Удалено!" : "Не найдено!";
        System.out.println(res);
    }

    public Book findBookByTitle(String name) {
        for (Book book : books) {
            if (book.getTitle().equals(name)) return book;
        }
        throw new NoSuchElementException("Не найдено!");
    }

    public List<Book> findByAuthor(String author) {
        List<Book> finded = new ArrayList<>();
        boolean isFind = false;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) finded.add(book);
            isFind = true;
        }
        if (!isFind) throw new NoSuchElementException("Не найдено!");
        else return finded;
    }

    @Override
    public List<Book> findAllBooks() {
        return books;
    }
}
