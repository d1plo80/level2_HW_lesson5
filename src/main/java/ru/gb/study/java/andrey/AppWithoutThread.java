package ru.gb.study.java.andrey;

import java.util.Arrays;

public class AppWithoutThread {
    private static final int size = 10000000;
    private float[] array = new float[size];

    public void start() {
        fill();
        setNewValue();
    }

    private void fill() {
        Arrays.fill(array, 1f);
    }

    private void setNewValue() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Общее время: " + (System.currentTimeMillis() - a));
    }

}
