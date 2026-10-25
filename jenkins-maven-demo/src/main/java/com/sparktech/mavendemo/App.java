package com.sparktech.mavendemo;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Jenkins Maven Demo");
        System.out.println("Java version : " + System.getProperty("java.version"));
        System.out.println("10 + 5 = " + calculator.add(10, 5));
        System.out.println("10 - 5 = " + calculator.subtract(10, 5));
        System.out.println("10 * 5 = " + calculator.multiply(10, 5));
        System.out.println("10 / 5 = " + calculator.divide(10, 5));
        System.out.println("Is 7 even? " + calculator.isEven(7));
    }
}
