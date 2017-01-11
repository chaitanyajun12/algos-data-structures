package com.ib.math;

import java.util.ArrayList;

/**
 * Created by krishna.m1 on 09/05/16.
 */
public class PrimeSum {

    public ArrayList<Integer> primesum(int a) {

        ArrayList<Integer> primes = new ArrayList<>();

        for(int i = 2; i < a; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }

        int i = 0;
        int j = primes.size() - 1;
        ArrayList<Integer> result = new ArrayList<>();

        while (i <= j) {
            int sum = primes.get(i) + primes.get(j);
            if(sum == a) {
                result.add(primes.get(i));
                result.add(primes.get(j));
                break;
            } else if(sum > a) {
                j--;
            } else {
                i++;
            }
        }

        return result;
    }

    public boolean isPrime(int n) {

        int N = (int) Math.sqrt(n);
        for(int i = 2; i <= N; i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String args[]) {

        System.out.println(new PrimeSum().primesum(20));

    }
}
