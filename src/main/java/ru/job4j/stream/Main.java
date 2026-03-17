package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(Suit.values())
                .flatMap(suit -> Arrays.stream(Value.values())
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);
    }
}

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8
}

class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
