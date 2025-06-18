package ru.job4j.oop;

public class Fox {
    public void tryEat(Ball ball) {
        System.out.println("Fox tried to eat the Ball.");
        ball.tryRun(true);
    }
}
