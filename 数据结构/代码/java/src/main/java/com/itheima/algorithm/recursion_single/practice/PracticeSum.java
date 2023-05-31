package com.itheima.algorithm.recursion_single.practice;

/**
 * @author lxk
 * @date 2023/5/29
 * @since 1.0
 */
public class PracticeSum {
    public static void main(String[] args) {
//        System.out.println(sum(20000, 0));
        System.out.println(sum(4));
    }

    /**
     * 尾递归或尾调用才会被优化
     * Scala或C++的编译器可以实现代码优化
     * 只有少部分语言的编译器可以做尾调用和尾递归的优化
     * 对于java用循环替换递归解决爆栈问题
     *
     * @param n
     * @param add
     * @return
     */
    public static int sum(int n, int add) {
        if (n == 1) {
            return n + add;
        }
        return sum(n - 1, add + n);
    }

    public static int sum(int n) {
        int sum = 0;
        for (int i = n; i > 0; i--) {
            sum += i;
        }
        return sum;
    }


}
