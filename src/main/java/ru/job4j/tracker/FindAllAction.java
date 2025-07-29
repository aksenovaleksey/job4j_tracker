package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    private final Output output;

    public FindAllAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать все заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Вывод всех заявок ===");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            output.println("Заявок нет.");
        } else {
            for (Item item : items) {
                output.println(item);
            }
        }
        return true;
    }
}
