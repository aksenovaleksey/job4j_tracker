package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        Predicate<Person> name = p -> p.getName() != null && p.getName().contains(key);
        Predicate<Person> surname = p -> p.getSurname() != null && p.getSurname().contains(key);
        Predicate<Person> phone = p -> p.getPhone() != null && p.getPhone().contains(key);
        Predicate<Person> address = p -> p.getAddress() != null && p.getAddress().contains(key);

        var combine = name.or(surname).or(phone).or(address);

        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}