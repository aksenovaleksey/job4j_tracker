package ru.job4j.pojo;

public class Book {
    private String name;
    private int numberOfpages;

    public Book(String name, int numberOfpages) {
        this.name = name;
        this.numberOfpages = numberOfpages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfpages() {
        return numberOfpages;
    }

    public void setNumberOfpages(int numberOfpages) {
        this.numberOfpages = numberOfpages;
    }
}