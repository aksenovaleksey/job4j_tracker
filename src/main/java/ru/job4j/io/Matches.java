package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());

            if (matches >= 1 && matches <= 3 && matches <= count) {
                count -= matches;
                System.out.println("Остаток спичек =" + count);
                turn = !turn;
            } else {
                System.out.println("Введите от 1 до 3 и не более остатка");
            }
            if (count == 0) {
                break;
            }
        }

        if (turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
