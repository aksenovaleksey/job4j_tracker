package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println("Cat's name is." + this.name);
        System.out.println("There is food." + this.food);
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

        public static void main(String[] args) {
            Cat gav = new Cat();
            gav.giveNick("Gav");
            gav.eat("cutlet");
            gav.show();

            Cat black = new Cat();
            black.giveNick("Black");
            black.eat("fish");
            black.show();
    }
}