package com.itheima.datastructure.array;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author lxk
 * @date 2023/4/27
 * @since 1.0
 */
public class PracticeDynamicArray implements Iterable<Integer> {
    private int capacity = 8;
    private int size = 0;
    private int[] arr = new int[capacity];

    private void addLast(int element) {
//        arr[size] = element;
//        size++;

        add(size, element);
    }

    private void add(int index, int element) {
        if (index >= 0 && index < size) {
            System.arraycopy(arr, index, arr, index + 1, size - index);
        }
        arr[index] = element;
        size++;
    }

    public void foreach(Consumer<Integer> consumer) {
        for (int i : arr) {
            consumer.accept(i);
        }
    }

    public static void main(String[] args) {
        PracticeDynamicArray array = new PracticeDynamicArray();
        array.add(0, 1);
        array.add(1, 1);
        array.add(2, 1);
        array.add(3, 1);
        array.add(4, 1);
        array.add(5, 1);
        array.add(6, 1);
        array.add(7, 1);

//        array.foreach((e) -> System.out.println(e));
        array.forEach((e)-> System.out.println(e));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return arr[i++];
            }
        };
    }
}
