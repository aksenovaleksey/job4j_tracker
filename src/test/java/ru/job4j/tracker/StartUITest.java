package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new MockInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "edited item"
        };
        StartUI.replaceItem(new MockInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName()).isEqualTo("edited item");
    }

    @Test
    void whenDeleteItemWithInvalidIdThenReturnErrorMessage() {
        Tracker tracker = new Tracker();
        String[] answers = {"123"};
        Input input = new MockInput(answers);
        StartUI.deleteItem(input, tracker);
        Item item = tracker.findById(123);
        assertThat(item).isNull();
    }
}