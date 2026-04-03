package com.learn.dataStructuresAndAlgorithms;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

    @Test
    public void test1() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.loop2(System.out::println);
    }

    @Test
    public void test2(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);

        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }
    }

    @Test
    public void test3(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addLast(4);

//        for (Integer i : singlyLinkedList) {
//            System.out.println(i);
//        }
        System.out.println(singlyLinkedList.get(4));
    }
}
