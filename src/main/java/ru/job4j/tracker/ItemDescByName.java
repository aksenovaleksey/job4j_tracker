package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        if (o1.getName() == null && o2.getName() == null) {
            return 0;
        }
        if (o1.getName() == null) {
            return -1;
        }
        if (o2.getName() == null) {
            return 1;
        }
        return o2.getName().compareTo(o1.getName());
    }
}
