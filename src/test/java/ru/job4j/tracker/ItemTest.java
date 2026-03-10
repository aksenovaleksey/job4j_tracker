package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @Test
    public void whenSortAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Zebra"));
        items.add(new Item(2, "Apple"));
        items.add(new Item(3, "Banana"));

        List<Item> expected = new ArrayList<>();
        expected.add(new Item(2, "Apple"));
        expected.add(new Item(3, "Banana"));
        expected.add(new Item(1, "Zebra"));

        Collections.sort(items, new ItemAscByName());

        assertEquals(expected, items);
    }

    @Test
    public void whenSortDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Apple"));
        items.add(new Item(2, "Zebra"));
        items.add(new Item(3, "Banana"));

        List<Item> expected = new ArrayList<>();
        expected.add(new Item(2, "Zebra"));
        expected.add(new Item(3, "Banana"));
        expected.add(new Item(1, "Apple"));

        Collections.sort(items, new ItemDescByName());

        assertEquals(expected, items);
    }
}