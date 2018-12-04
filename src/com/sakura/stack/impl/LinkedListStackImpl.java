package com.sakura.stack.impl;

import com.sakura.links.LinkedList;
import com.sakura.stack.Stack;

/**
 * 1.4 基于链表实现的栈结构
 * @param <E>
 */
public class LinkedListStackImpl<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStackImpl() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: Top [ ");
        res.append(list);
        res.append(" ] bottom");
        return res.toString();
    }
}
