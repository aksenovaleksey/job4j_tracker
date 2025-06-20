package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        int sumResult = sum(d);
        int multiplyResult = multiply(d);
        int minusResult = minus(d);
        int divideResult = divide(d);

        return sumResult + multiplyResult + minusResult + divideResult;
    }

    public static void main(String[] args) {
        int resultSum = sum(10);
        System.out.println("sum(10): " + resultSum);
        Calculator calculator = new Calculator();
        int resultMultiply = calculator.multiply(10);
        System.out.println("multiply(10): " + resultMultiply);
        int resultMinus = minus(20);
        System.out.println("minus(20): " + resultMinus);
        int resultDivide = calculator.divide(25);
        System.out.println("divide(25): " + resultDivide);
        int resultSumAll = calculator.sumAllOperation(20);
        System.out.println("sumAllOperation(20): " + resultSumAll);
    }
}


