package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

public class FindByIdAction implements UserAction {
    private final Output output;

    public FindByIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Поиск заявок по id ===");
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.println("Найденная заявка: " + item);
        } else {
            output.println("Заявка с таким id не найдена.");
        }
       return true;
    }
}
