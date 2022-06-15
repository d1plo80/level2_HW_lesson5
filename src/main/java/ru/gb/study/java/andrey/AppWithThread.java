package ru.gb.study.java.andrey;

import java.util.Arrays;

public class AppWithThread {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private float[] array = new float[size];
    private float[] a1 = new float[h];
    private float[] a2 = new float[h];



    public void start() throws InterruptedException {
        fill();
        long a = System.currentTimeMillis();
        copyArray();
        Thread thread1 = setNewValue(a1);
        Thread thread2 = setNewValue(a2);
        thread1.join();
        thread2.join();
        stickArray();
        System.out.println("Общее время в двух потоках: " + (System.currentTimeMillis() - a));
    }

    private void fill() {
        Arrays.fill(array, 1F);
    }

    private Thread setNewValue(float[] arr){
        Thread thread = new Thread(() -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread.start();
        return thread;
    }

    private void copyArray() {
        System.arraycopy(array, 0, a1, 0, h);
        System.arraycopy(array, h, a2, 0, h);
    }

    private void stickArray() {
        System.arraycopy(a1, 0, array, 0, h);
        System.arraycopy(a2, 0, array, h, h);
    }

}
