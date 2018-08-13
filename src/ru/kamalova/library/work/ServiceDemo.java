package ru.kamalova.library.work;


import ru.kamalova.library.entity.Book;
import ru.kamalova.library.entity.LibraryFiction;
import ru.kamalova.library.service.LibraryService;
import ru.kamalova.library.service.Service;

import java.util.NoSuchElementException;

public class ServiceDemo {

    Service myService;

    public ServiceDemo() {
        myService = new LibraryService();
        ((LibraryService) myService).setLibrary(new LibraryFiction());
    }

    public void start() {
        myService.addBook(new Book("Война и мир", "Толстой", 1950, 2000));
        myService.addBook(new Book("Реликт", "Головачев", 2017, 500));
        myService.addBook(new Book("Абсолютный игрок", "Головачев", 2012, 650));
        myService.addBook(new Book("Бич времен", "Головачев", 2000, 370));
        myService.addBook(new Book("Таинственный остров", "Жюль Верн", 1989, 485));
        myService.addBook(new Book("С Земли на Луну", "Жюль Верн", 1997, 333));
        myService.addBook(new Book("Урфин Джюс", "Волков", 2003, 670));
        myService.addBook(new Book("7 подземных королей", "Волков", 1979, 760));


        System.out.println("Все, что есть:");
        myService.findAllBooks().forEach(System.out::println);
        System.out.println("============================================================");

        System.out.println("Ищем по автору 'Головачев': ");
        try {
            myService.findByAuthor("Головачев").forEach(System.out::println);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("============================================================");

        System.out.println("Ищем по названию 'Трампампам': ");
        Book finded;
        try {
            finded = myService.findByTitle("Трампампам");
            System.out.println(finded);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("============================================================");

        System.out.println("Ищем по названию 'Урфин Джюс': ");
        try {
            finded = myService.findByTitle("Урфин Джюс");
            System.out.println("Найдено: " + finded);
            myService.removeBook(finded);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("============================================================");

        System.out.println("Осталось: ");
        myService.findAllBooks().forEach(System.out::println);

        System.out.println("============================================================");
        myService.removeBook(new Book("ssss", "dddd", 1, 1));

    }
}
