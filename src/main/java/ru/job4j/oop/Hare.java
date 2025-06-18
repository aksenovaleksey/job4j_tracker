package ru.job4j.oop;

public class Hare {
    public void tryEat(Ball ball) {
        System.out.println("Hare tried to eat the Ball.");
        ball.tryRun(false);
    }
}
