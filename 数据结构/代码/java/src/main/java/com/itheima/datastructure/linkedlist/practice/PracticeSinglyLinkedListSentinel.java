package com.itheima.datastructure.linkedlist.practice;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author lxk
 * @date 2023/4/28
 * @since 1.0
 */
public class PracticeSinglyLinkedListSentinel<T> implements Iterable<T> {
    private Node head = null;

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
        Node<T> p = head;

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
        head = new Node(value, head);
    }

    public void loop1(Consumer<T> consumer) {
        Node<T> p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    private Node<T> findLast() {
        if (head == null) {
            return null;
        }
        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    public void addLast(T value) {
        Node<T> last = findLast();
        if (last == null) {
            //链表为空
            addFirst(value);
            return;
        }

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
        for (i = 0, p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public void insert(int index, T value) {
        if (index == 0) {
            addFirst(value);
            return;
        }

        Node pre = find(index - 1);
        if (null == pre) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }
        pre.next = new Node(value, pre.next);
    }

    public void removeFirst() {
        if(null == head){
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", 0));
        }
        head = head.next;
    }

    public void remove(int index) {
        if (0 == index) {
            removeFirst();
            return;
        }

        Node pre = find(index - 1);
        if (null == pre) {
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }

        if (null == pre.next){
            throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
        }

        pre.next = pre.next.next;
    }


    public static void main(String[] args) {
        PracticeSinglyLinkedListSentinel<String> list1 = new PracticeSinglyLinkedListSentinel<>();
        list1.addFirst("1");
//        PracticeSinglyLinkedList<String> list2 = new PracticeSinglyLinkedList<>();
//        list2.addFirst("2");
        list1.addFirst("3");
        list1.addFirst("4");
//        list.addFirst("4");
//        list.loop1((val) -> {
//            System.out.println(val);
//        });
//        list.addLast("0");

//        for (String s : list2) {
//            System.out.println(s);
//        }

        list1.insert(6, "2");

        for (String s : list1) {
            System.out.println(s);
        }
    }
}
