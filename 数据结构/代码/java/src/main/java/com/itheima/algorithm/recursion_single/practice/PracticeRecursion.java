package com.itheima.algorithm.recursion_single.practice;

import java.util.Arrays;

/**
 * @author lxk
 * @date 2023/5/9
 * @since 1.0
 */
public class PracticeRecursion {


    public static int count(int n) {
        if (n == 1) {
            return 1;
        }
        return n * count(n - 1);
    }

    public static void reversePrintStr1(String str, int charAt) {
        if (charAt == str.length()) {
            return;
        }
        reversePrintStr1(str, charAt + 1);
        System.out.print(str.charAt(charAt));
    }

    public static void reversePrintStr2(String str, int length) {
        if (length == -1) {
            return;
        }

        System.out.print(str.charAt(length));
        reversePrintStr2(str, length - 1);


    }

    public static void search(int[] arr, int target) {
        find(arr, 0, arr.length - 1, target);
    }

    public static void find(int[] arr, int i, int j, int aim) {
        if (i > j) {
            return;
        }
        int m = (i + j) >>> 1;
        if (arr[m] > aim) {
            find(arr, i, m - 1, aim);
        } else if (arr[m] < aim) {
            find(arr, m + 1, j, aim);
        } else {
            System.out.println(m);
        }

    }

    public static void bubbleSort(int[] arr, int j) {
        if (j == 0) {
            return;
        }

        int x = 0;
        for (int i = 0; i < j; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            if (a > b) {
                int temp = b;
                arr[i + 1] = a;
                arr[i] = temp;
                x = i;
            }
        }
//        bubbleSort(arr, j - 1);
        bubbleSort(arr, x);
    }

    public static void sort(int[] arr) {
        bubbleSort(arr, arr.length - 1);
    }

    public static void insertSort(int[] arr, int low) {

    }

    public static void main(String[] args) {

        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));

//        System.out.println(count(5));

//        String str = "abcdefg";
//        reversePrintStr1("abcdefg",0);
//        reversePrintStr2(str, str.length() - 1);

//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        find(arr, 0, arr.length - 1, 12);

    }
}
