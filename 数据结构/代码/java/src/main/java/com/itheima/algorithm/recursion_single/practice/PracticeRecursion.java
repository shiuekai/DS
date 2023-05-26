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

    /**
     * low 代表未排序范围开始索引
     *
     * @param arr
     * @param low
     */
    public static void insertSort(int[] arr, int low) {
        if (arr.length == low) {
            return;
        }

        int t = arr[low];
        //代表已排序范围的结束索引
        int i = low - 1;

        //找到比插入值小的值才退出循环
        while (i >= 0 && arr[i] > t) {
            arr[i + 1] = arr[i];
            i--;
        }

        arr[i + 1] = t;
        insertSort(arr, low + 1);
    }


    public static void insertionSort(int[] arr, int start, int end) {
        if (start >= end) {  //递归终止条件
            return;
        }
        insertionSort(arr, start, end - 1);  //递归排序start到end-1之间的元素
        int x = arr[end];                   //将最后一个元素取出来
        int j = end - 1;                     //从最后一个元素的前一个元素开始向前遍历
        while (j >= start && arr[j] > x) {   //如果j大于等于start并且j所在的元素比x大
            arr[j + 1] = arr[j];            //将j所在元素后移一位
            j--;                            //继续往前找
        }
        arr[j + 1] = x;                     //将最后一个元素插入到正确的位置
    }


    /**
     * low 代表未排序范围开始索引
     * high 代表未排序范围结束索引
     * low = 3  high = 5
     * [7,6,5,4,3,2,1]
     * [7,6,5,2,3,4,1]
     *
     * @param arr
     * @param low
     */
    public static void insertSort(int[] arr, int low, int high) {
        if (high == low) {
            return;
        }

        int t = arr[low + 1];
        //代表已排序范围的结束索引
        int i = low;

        //6 5 4
        //找到比插入值小的值才退出循环
        while (i >= low && arr[i] > t) {
            arr[i + 1] = arr[i];
            i--;
        }

        //5 6 4
        arr[i + 1] = t;
        insertSort(arr, low + 1, high);
    }

    public static void practiceInsertSort(int[] arr, int low) {
        if (low == arr.length) {
            return;
        }

        int i = low - 1;
        int t = arr[low];

        while (i >= 0 && t < arr[i]) {
            arr[i + 1] = arr[i];
            i--;
        }

        if (i + 1 != low) {
            arr[i + 1] = t;
        }

        practiceInsertSort(arr, low + 1);
    }

    public static void main(String[] args) {

        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

//        practiceInsertSort(arr,1);
        insertSort(arr,3,5);
        System.out.println(Arrays.toString(arr));



    }
}
