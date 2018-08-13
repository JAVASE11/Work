package ru.kamalova.collection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsProcessor {
    String path;

    public CollectionsProcessor(String path) {
        this.path = path;
    }

    public void showSortedUniqueWords() {
        System.out.println("Отсортированный список слов --------------------");
        getSortedUniqueWords()
                .forEach(System.out::println);
    }

    public void showCountOfWords() {
        System.out.println("Список слов, сортированый по количеству ------");

        getCountOfWords()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
    }

    private List<String> getSortedUniqueWords() {
        List<String> result = new ArrayList<>();
        try {
            result = Files.lines(Paths.get(path))
                    .map(x -> x.replaceAll("[-.?!)(,:]", " "))
                    .flatMap(x -> Arrays.stream(x.trim().split("\\s+")))
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted(String::compareTo)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Map<String, Long> getCountOfWords() {
        Map<String, Long> map = new HashMap<>();
        try {
            map = Files.lines(Paths.get(path))
                    .map(x -> x.replaceAll("[-.?!)(,:]", " "))
                    .flatMap(x -> Arrays.stream(x.trim().split("\\s+")))
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
