package ru.gb.study.java.andrey;

import java.util.Arrays;

public class AppWithoutThread {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private float[] array = new float[size];

    public void start() {
        fill();
        setNewValue();
    }

    private void fill() {
        float startNum = 1;
        Arrays.fill(array, startNum);
    }

    private void setNewValue() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

//    public void print() {
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();
//    }
}
