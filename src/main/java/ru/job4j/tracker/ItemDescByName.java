package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return Comparator.nullsFirst(String::compareTo)
                .compare(o2.getName(), o1.getName());
    }
}