package com.ib.binarysearch;

/**
 * Created by krishna.m1 on 16/05/16.
 */
public class PowerFunction {

    public int pow(int x, int n, int d) {
        long power = power(x, n, d);
        return (int) (power % d + d) % d;
    }

    /* public float power1(int x, int n) {
        if (n == 0) {
            return 1;
        }

        float temp = power(x, n / 2);
        if ((n & 1) == 0) {
            return temp * temp;
        }

        if(n < 0) {
            return (temp * temp) / x;
        }

        return x * temp * temp;
    } */

    public long power(int x, int n, int d) {
        if (n == 0) {
            return 1;
        }

        long temp = power(x, n / 2, d);
        if ((n & 1) == 0) {
            return (temp * temp) % d;
        }

        return (x * temp * temp) % d;
    }

    public static void main(String args[]) {
        PowerFunction powerFunction = new PowerFunction();
        System.out.println(powerFunction.pow(-1, 1, 20));
    }
}
