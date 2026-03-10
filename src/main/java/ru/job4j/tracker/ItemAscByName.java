package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
       return Comparator.nullsFirst(String::compareTo)
                .compare(o1.getName(), o2.getName());
    }
}
