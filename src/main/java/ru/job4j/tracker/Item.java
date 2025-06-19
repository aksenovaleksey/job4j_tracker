package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void printInfo() {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println();
    }

    public static void main(String[] args) {
        Item item = new Item();
        item.printInfo();
        Item item2 = new Item("Товар 1");
        item2.printInfo();
        Item item3 = new Item(123, "Товар 2");
        item3.printInfo();
    }
}
