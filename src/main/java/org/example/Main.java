package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        load();
        System.out.println("end");
    }

    public static void load() throws InterruptedException {

        String res = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";

        int length = 100;
        int chance = 5;

        StringBuilder bar = new StringBuilder();
        bar.append("[");
        for (int i = 0; i < length; i++) {
            bar.append(randomChar());
        }
        bar.append("]");

        int i1 = 1;
        int l = 1;

        while (true) {
            for (int i = i1; i < length; i++) {
                bar.setCharAt(i, randomChar().charAt(0));
                if (i1 < l) {
                    i1++;
                }
                if (i1 == length) return;
            }
            System.out.print("[" + green + bar.subSequence(1, i1) + res + red + bar.substring(i1, length - 1) + res + "]" +  "\r");
            Thread.sleep(50);
            if (ThreadLocalRandom.current().nextInt(0, 101) < chance) {
                l += ThreadLocalRandom.current().nextInt(0, (int) (double) (length / 5));
                if (l >= length) l = length - 1;
            }
        }
    }

    private static String randomChar() {
        return Character.toString(ThreadLocalRandom.current().nextInt(33, 150));
    }
}