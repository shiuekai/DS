package com.itheima.datastructure.linkedlist.practice;

import java.util.Iterator;

/**
 * @author lxk
 * @date 2023/4/28
 * @since 1.0
 */
public class PracticeCircleDoubleLinkedListSentinel<T> implements Iterable<T> {
    private Node sentinel;

    public PracticeCircleDoubleLinkedListSentinel() {
        sentinel = new Node(null, -1, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
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
        return null;
    }

    public void addFirst(T value) {
        Node next = sentinel.next;
        Node node = new Node(sentinel, value, next);
        sentinel.next = node;
        next.pre = node;
    }

    public void removeFirst() {
        if (sentinel.next == sentinel) {
            return;
        }

        Node remove = sentinel.next;
        sentinel.next = remove.next;
        remove.next.pre = sentinel;
    }

    public void addLast(T value) {
        Node last = sentinel.pre;
        Node newLast = new Node(last, value, sentinel);
        last.next = newLast;
        sentinel.pre = newLast;
    }

    public void removeLast() {
        if (sentinel.next == sentinel) {
            return;
        }

        Node remove = sentinel.pre;
        Node pre = remove.pre;
        remove.pre.next = sentinel;
        sentinel.pre = remove.pre;
//        pre.next = sentinel;
//        sentinel.pre = pre;
    }

    public void insert(int index, T value) {

    }

    public void removeByValue(T value) {
        Node node = findByValue(value);
        if (node == null) {
            return;
        }

        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;

    }

    private Node findByValue(T value) {
        Node node = sentinel.next;
        while (node != sentinel) {
            if (value == node.value) {
                return node;
            }
            node = node.next;
        }
        return null;
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
        Node<T> p = sentinel.next;

        @Override
        public boolean hasNext() {
            return p != sentinel;
        }

        @Override
        public T next() {
            T value = p.value;
            p = p.next;
            return value;
        }
    }


    public static void main(String[] args) {
        PracticeCircleDoubleLinkedListSentinel<Integer> list = new PracticeCircleDoubleLinkedListSentinel<>();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(5);
//        list.removeFirst();
//        list.removeFirst();
//        list.removeFirst();
//        list.removeFirst();
//        list.removeFirst();
//        list.removeFirst();
        list.removeByValue(2);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
