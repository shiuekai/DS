package com.itheima.algorithm.recursion_multi;

/**
 * @author lxk
 * @date 2023/5/29
 * @since 1.0
 */
public class TestFibonacci {
    public static void main(String[] args) {
//        System.out.println(fibonacci(20));
//        System.out.println(sum(10000));
//        System.out.println(triangle(3, 2));
        print(5);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static int sum(int n) {
        if (n == 1) {
            return n;
        }
        return n + sum(n - 1);
    }

    public static int triangle(int i, int j) {
        if (j == 0 || j == i) {
            return 1;
        }

        return triangle(i - 1, j - 1) + triangle(i - 1, j);
    }

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle(i, j));
            }
            System.out.println();
        }
    }

}
