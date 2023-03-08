package org.example.model;

import com.opencsv.bean.*;
import org.example.converter.ProfessionCsvConverter;

import java.time.LocalDate;
import java.util.List;

public class Person {
    @CsvBindByName(required = true)
    private String firstName;
    @CsvBindByName(required = true)
    private String lastName;

    @CsvBindByName
    private Gender gender;

    @CsvBindByName
    @CsvDate("dd/MM/yyyy")
    private LocalDate birthDate;

    @CsvCustomBindByName(converter = ProfessionCsvConverter.class)
    private Profession profession;

    @CsvBindAndSplitByName(elementType = String.class, splitOn = "\\|", writeDelimiter = "|")
    private List<String> hobbies;

    @CsvRecurse
    private Author author;

    public Person() {
    }

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate, Profession profession,
                  List<String> hobbies, Author author) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.profession = profession;
        this.hobbies = hobbies;
        this.author = author;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", profession=" + profession +
                ", hobbies=" + hobbies +
                ", author=" + author +
                '}';
    }
}
