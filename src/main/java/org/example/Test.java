package org.example;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.example.model.Author;
import org.example.model.Gender;
import org.example.model.Person;
import org.example.model.Profession;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class Test {
    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        // READ LINES FROM CSV AS STRINGS
        Path csvPath = Paths.get("src\\main\\resources\\MOCK_DATA.csv");
        List<String> lines = Files.readAllLines(csvPath);
        lines.forEach(System.out::println);

        // CSV TO POJO
        List<Person> persons = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(csvPath)) {
            var csvToPerson = new CsvToBeanBuilder<Person>(reader)
                    .withType(Person.class)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();
            persons.addAll(csvToPerson.parse());
        }
        persons.forEach(System.out::println);

        // POJO TO CSV
        Path newCsvPath = Paths.get("persons.csv");
        Files.deleteIfExists(newCsvPath);
        try (Writer writer = Files.newBufferedWriter(newCsvPath)) {
            var personToCsv = new StatefulBeanToCsvBuilder<Person>(writer)
                    .withApplyQuotesToAll(false)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();
            personToCsv.write(List.of(
                    new Person("Billel", "KETROUCI", Gender.MALE, LocalDate.of(1996, Month.SEPTEMBER, 9),
                            new Profession("Software Engineer", 45_000), List.of("Mangas", "Sports"), new Author("Tite Kubo", "Genius")),
                    new Person("El Bakay", "BOURAJOINI", Gender.MALE, LocalDate.of(1994, Month.MARCH, 3),
                            new Profession("Network Engineer", 42_000), List.of("Video Games", "Mangas"), new Author("Tite Kubo", "Genius")),
                    new Person("Meriem", "KECHEROUD", Gender.FEMALE, LocalDate.of(1995, Month.JULY, 27),
                            new Profession("Software Engineer", 39_000), List.of("Shopping"), new Author("Tite Kubo", "Genius"))
            ));
        }
    }
}
