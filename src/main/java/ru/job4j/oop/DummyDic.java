package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String eng = "eng";
        String result = word.engToRus(eng);
        System.out.println(result);
    }
}
