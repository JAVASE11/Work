package ru.kamalova.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {

    public static void main(String[] args) {
        String s1 = "25.07.1921";
        String s2 = "02.09.1920";
        String s3 = "Friday, Aug 10, 2018 12:10:56 PM";

        LocalDate myBirthday = LocalDate.of(1979, Month.SEPTEMBER, 1);
        calcMyAge(myBirthday);
        showDifference(s1, s2);
        showFormat(s3);

    }

    private static void calcMyAge(LocalDate date) {
        Period period = date.until(LocalDate.now());
        System.out.println("Мой возраст: ");
        System.out.println(period.getYears() + " лет, " + period.getMonths() + " месяцев, " + period.getDays() + " дней.\n");
    }

    private static void showDifference(String s1, String s2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate d1 = LocalDate.parse(s1, formatter);
        LocalDate d2 = LocalDate.parse(s2, formatter);
        System.out.printf("Между датами %s и %s разница %d дней.\n", s1, s2, Math.abs(DAYS.between(d1, d2)));
    }

    private static void showFormat(String s) {
        System.out.print("\nChange data from:  " + s + "\nto: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a", Locale.ENGLISH);
        LocalDate dateTime = LocalDate.parse(s, formatter);
        System.out.println(dateTime);
    }
}
