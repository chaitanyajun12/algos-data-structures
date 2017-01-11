package com.ib.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by krishna.m1 on 14/05/16.
 */
public class FindDuplicates {

    public int repeatedNumber(final List<Integer> a) {

        if(a.size() == 1)
            return a.get(0);

        int N = a.size();
        int dups[] = new int[N - 1];

        for(int i = 0; i < N; i++) {
            dups[a.get(i) - 1] += 1;
        }

        for(int i = 0; i < N - 1; i++) {
            if(dups[i] > 1)
                return i + 1;
        }

        return 0;
    }

    public static void main(String args[]) {

        ArrayList<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(4);
        input.add(1);
        input.add(4);
        input.add(1);


        System.out.print(new FindDuplicates().repeatedNumber(input));

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for(int i = 1; i <= 10; i++) {
            System.out.println(N + " \\u10035 " + i + " = " + (N * i));
        }
    }
}
