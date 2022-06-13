package ru.gb.study.java.andrey;

import java.util.Arrays;

public class AppWithThread extends Thread {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private float[] array = new float[size];
    private float[] a1 = new float[h];
    private float[] a2 = new float[h];


    public void start() {
        fill();
        copyArray();
        try {
            long a = System.currentTimeMillis();
            setNewValue(a1);
            System.out.println(System.currentTimeMillis() - a);
            long b = System.currentTimeMillis();
            setNewValue(a2);
            System.out.println(System.currentTimeMillis() - b);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        stickArray();

    }

    private void fill() {
        float startNum = 1;
        Arrays.fill(array, startNum);
    }

    private synchronized void setNewValue(float[] arr) throws InterruptedException {
        Thread thread = new Thread(() -> {
//            long a = System.currentTimeMillis();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
//            System.out.println(System.currentTimeMillis() - a);
        });
        thread.start();
        thread.join();


    }

    private void copyArray() {
        long a = System.currentTimeMillis();
        System.arraycopy(array, 0, a1, 0, h);
        System.arraycopy(array, h, a2, 0, h);
        System.out.println(System.currentTimeMillis() - a);
    }

    private void stickArray() {
        long a = System.currentTimeMillis();
        System.arraycopy(a1, 0, array, 0, h);
        System.arraycopy(a2, 0, array, h, h);
        System.out.println(System.currentTimeMillis() - a);
    }

    public void print(float[] arr) {
        for (float v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
