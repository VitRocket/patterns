package com.github.vitrocket.patterns.sorted;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by VitRocket on 10.05.2018.
 */
public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        int[] numbers = new int[20];
        int[] numbers2 = new int[20];

        for (int i = 0; i < 20; i++) {
            int num = random.nextInt(100);
            numbers[i] = num;
            numbers2[i] = num;
        }

        int[] numbers3 = {1, 2, 3, 4, 5, 6, 25, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] numbers4 = {1, 2, 3, 4, 5, 6, 25, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

//        int[] numbers3 = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] numbers4 = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};


//        System.out.println(Arrays.toString(sort01(numbers)));
//        System.out.println("-------------------------------");
//        System.out.println(Arrays.toString(sort02(numbers2)));

        System.out.println(Arrays.toString(sort02(numbers3)));
        System.out.println("-------------------------------");
        System.out.println(Arrays.toString(sort02(numbers4)));


    }

    private static int[] sort01(int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (i < numbers.length && (numbers[i + 1] < numbers[i])) {
                int temp = numbers[i + 1];
                numbers[i + 1] = numbers[i];
                numbers[i] = temp;
                i = -1;
                count++;
                System.out.println(Arrays.toString(numbers));
            }
        }
        System.out.println("count: " + count);
        return numbers;
    }

    private static int[] sort02(int[] numbers) {
        int count = 0;
        for (int i = numbers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                    count++;
                    System.out.println(Arrays.toString(numbers));
                }
            }
        }
        System.out.println("count: " + count);
        return numbers;
    }

}
