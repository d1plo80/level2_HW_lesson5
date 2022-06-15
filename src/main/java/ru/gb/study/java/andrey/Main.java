package ru.gb.study.java.andrey;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       new AppWithoutThread().start();
       new AppWithThread().start();
    }
}