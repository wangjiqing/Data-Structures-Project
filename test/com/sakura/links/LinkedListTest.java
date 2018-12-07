package com.sakura.links;

import com.sakura.links.impl.SinglyLinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 77);
        System.out.println(linkedList);

        linkedList.addLast(88);
        System.out.println(linkedList);

        linkedList.set(2, 87);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);
    }
}
