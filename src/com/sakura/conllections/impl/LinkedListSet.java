package com.sakura.conllections.impl;

import com.sakura.conllections.Set;
import com.sakura.links.LinkedList;
import com.sakura.links.impl.SinglyLinkedList;

/**
 * 基于链表实现的Set集合类
 * @param <E>
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new SinglyLinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
