package org.example.model;

public class Profession {
    private String title;
    private int salary;

    public Profession() {
    }

    public Profession(String title, int salary) {
        this.title = title;
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "title='" + title + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
