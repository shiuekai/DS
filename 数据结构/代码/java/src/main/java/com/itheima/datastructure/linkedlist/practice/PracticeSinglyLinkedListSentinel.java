package com.itheima.datastructure.linkedlist.practice;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author lxk
 * @date 2023/4/28
 * @since 1.0
 */
public class PracticeSinglyLinkedListSentinel<T> implements Iterable<T> {
    private Node head = new Node(666, null);

    @Override
    public Iterator<T> iterator() {
//        return new Iterator<T>() {
//            Node<T> p = head;
//
//            @Override
//            public boolean hasNext() {
//                return p!=null;
//            }
//
//            @Override
//            public T next() {
//                T value = p.value;
//                p = p.next;
//                return value;
//            }
//        };
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        Node<T> p = head.next;

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public T next() {
            T value = p.value;
            p = p.next;
            return value;
        }
    }

    private static class Node<T> {
        private T value;

        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(T value) {
//        head = new Node(value, head);
        insert(0, value);
    }

    public void loop1(Consumer<T> consumer) {
        Node<T> p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    private Node<T> findLast() {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public void addLast(T value) {
        Node<T> last = findLast();
        last.next = new Node(value, null);
    }

    public void test() {
        int i;
        Node p;
        for (i = 0, p = head; p != null; p = p.next, i++) {

        }
    }

    public Node find(int index) {
        int i;
        Node p;
        for (i = -1, p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public void insert(int index, T value) {
        Node pre = find(index - 1);
        if (null == pre) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        pre.next = new Node(value, pre.next);
    }

    public void removeFirst() {
        remove(0);
    }

    public void remove(int index) {
        Node pre = find(index - 1);
        if (null == pre) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }

        if (null == pre.next) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }

        pre.next = pre.next.next;
    }


    public static void main(String[] args) {
        PracticeSinglyLinkedListSentinel<Integer> list = new PracticeSinglyLinkedListSentinel<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.remove(0);
        list.remove(2);
        list.remove(0);
        list.removeFirst();
//        list.remove(0);

        for (Integer s : list) {
            System.out.println(s);
        }
    }
}
