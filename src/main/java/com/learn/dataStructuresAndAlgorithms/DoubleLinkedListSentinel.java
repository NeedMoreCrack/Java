package com.learn.dataStructuresAndAlgorithms;

import java.util.Iterator;

public class DoubleLinkedListSentinel implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public DoubleLinkedListSentinel(){
        head = new Node(null,000,null);
        tail = new Node(null,000,null);
        head.next = tail;
        tail.next = head;
    }

    public void addFirst(int value){

    }

    public void removeFirst(){

    }

    public void addLast(int value){

    }

    public void removeLast(){

    }
}
