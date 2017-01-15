package edu.mum.CS435.Lab02;

/**
 * Created by hungduong on 11/3/16.
 */
public class Fibo {
    public int fibonacci(int n) {
        if (n < 1)
            return 0;

        if (n == 0 || n == 1)
            return 1;

        int f = 0, f0 = 0, f1 = 1;
        for(int i = 2; i <= n; i++) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }

        return f;
    }
}
