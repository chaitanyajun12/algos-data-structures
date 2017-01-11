package com.hackerearth.arrays;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by krishna.m1 on 08/12/16.
 */
public class PowerOfTime {

    private static int[] rotateLeft(int arr[]) {
        int rotatedArray[] = new int[arr.length];
        int N = arr.length;

        for(int i = 0; i < N; i++) {
            rotatedArray[(N - 1 + i) % N] = arr[i];
        }

        return rotatedArray;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int idealOrder[] = new int[N];
        LinkedList<Integer> queue = new LinkedList<>();

        int i;
        for(i = 0; i < N; i++) {
            queue.add(scanner.nextInt());
        }

        for(i = 0; i < N; i++) {
            idealOrder[i] = scanner.nextInt();
        }

        i = 0;
        int sum = 0;
        while (!queue.isEmpty()) {
            sum += 1;

            int n = queue.element();
            if(n != idealOrder[i]) {
                n = queue.remove();
                queue.add(n);
            } else {
                queue.remove();
                i += 1;
            }
        }

        System.out.println(sum);
    }

    private static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
