package ru.kamalova.collection;

public class Main {

    public static void main(String[] args) {
        CollectionsProcessor processor = new CollectionsProcessor("test.txt");

        processor.showSortedUniqueWords();
        processor.showCountOfWords();

    }
}
