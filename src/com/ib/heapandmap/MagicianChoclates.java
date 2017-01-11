package com.ib.heapandmap;

import java.util.*;

/**
 * Created by krishna.m1 on 17/12/16.
 */
public class MagicianChoclates {
    public int nchoc(int A, ArrayList<Integer> B) {
        if (B == null) {
            return 0;
        }

        PriorityQueue<Integer> choclateBoxes = new PriorityQueue<>(Collections.reverseOrder());
        for (int box = 0; box < B.size(); box++) {
            choclateBoxes.add(B.get(box));
        }

        int sum = 0;
        int mod = (int) (Math.pow(10, 9) + 7);

        for (int time = 1; time <= A; time++) {
            int n = choclateBoxes.poll();
            sum = (sum + (n % mod)) % mod;
            choclateBoxes.add((int) Math.floor(n / 2));
        }

        return sum;
    }

    public static void main(String args[]) {
        MagicianChoclates magicianChoclates = new MagicianChoclates();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2147483647);
        list.add(2000000014);
        list.add(2147483647);
        System.out.println(magicianChoclates.nchoc(10, list));
    }
}
