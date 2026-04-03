package com.learn.dataStructuresAndAlgorithms;

import com.learn.oop_19.Inter;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer> {
    private Node head = null;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

    private static class Node {
        int value;
        Node next;

        private Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(int value) {
        head = new Node(value,head);
    }

    public void loop1(Consumer<Integer> consumer){
        Node p = head;
        while (p != null){
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer){
        for(Node p = head; p != null;p = p.next){
            System.out.println(p.value);
        }
    }
}
