package com.itheima.datastructure.linkedlist.practice;

import java.util.Iterator;

/**
 * @author lxk
 * @date 2023/4/28
 * @since 1.0
 */
public class PracticeDoubleLinkedListSentinel<T> implements Iterable<T> {
    private Node head;

    private Node tail;

    public PracticeDoubleLinkedListSentinel() {
        this.head = new Node(null, 666, null);
        this.tail = new Node(null, 888, null);
        head.next = tail;
        tail.pre = head;
    }


    private static class Node<T> {

        private Node next;

        private T value;

        private Node pre;

        public Node(Node pre, T value, Node next) {
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }

    public Node findNode(int index) {
        int i;
        Node p;
        //到达尾哨兵代表结束
        for (i = -1, p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public void addFirst(T value) {
        insert(0, value);
    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(T value) {
        Node last = tail.pre;
        Node insert = new Node(last, value, tail);
        last.next = insert;
        tail.pre = insert;
    }

    public void removeLast() {
        Node last = tail.pre;
        if (head == last) {
            return;
        }
        tail.pre = last.pre;
        tail.pre.next = tail;
    }

    public void insert(int index, T value) {
        Node pre = findNode(index - 1);
        if (null == pre) {
            return;
        }
        Node next = pre.next;
        Node node = new Node(pre, value, next);
        pre.next = node;
        next.pre = node;
    }

    private void remove(int index) {
        Node pre = findNode(index - 1);
        if (null == pre) {
            return;
        }

        Node remove = pre.next;

        if (remove == tail) {
            return;
        }

        pre.next = remove.next;
        remove.next.pre = pre;
    }


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
            return p != tail;
        }

        @Override
        public T next() {
            T value = p.value;
            p = p.next;
            return value;
        }
    }


    public static void main(String[] args) {
        PracticeDoubleLinkedListSentinel<Integer> list = new PracticeDoubleLinkedListSentinel<>();
        list.insert(0, 1);
        list.insert(0, 0);
        list.remove(0);
        list.remove(0);
//        list.insert(1, 2);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
