package ru.kamalova.except;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrey_Vaganov on 12/5/2016.
 */
public class MainReader {

    /**
     * Формат даты
     */
    private static final String DATE_FORMAT_PATTERN = "dd.MM.yyyy";

    /**
     * Форматтер, используется для преобразования строк в даты и обратно
     */
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT_PATTERN);


    /**
     * Точка входа в программу
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            readFile();
        } catch (MyException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Метод для чтения дат из файла
     */

    public static void readFile() throws MyException {
        try (BufferedReader byfReader = new BufferedReader(new FileReader("file1.txt"))) {

            String strDate = byfReader.readLine();
            while (strDate != null) {
                Date date;
                try {
                    date = parseDate(strDate);
                    System.out.printf("%1$td-%1$tm-%1$ty \n", date);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
                strDate = byfReader.readLine();
            }
        } catch (IOException e) {
            throw new MyException("File lost!");
        }
    }

    /**
     * Метод преобразует строковое представление даты в класс Date
     *
     * @param strDate строковое представление даты
     * @return
     */
    public static Date parseDate(String strDate) throws ParseException {
        return dateFormatter.parse(strDate);
    }
}