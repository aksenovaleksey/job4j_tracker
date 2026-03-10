package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
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
        return o1.getName().compareTo(o2.getName());
    }
}
