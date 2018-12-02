package com.sakura.stack.impl;

import com.sakura.array.Array;
import com.sakura.array.impl.ArrayImpl;
import com.sakura.stack.Stack;

public class ArrayStackImpl<E> implements Stack<E> {

    Array<E> array;

    public ArrayStackImpl(int capacity) {
        array = new ArrayImpl<>(capacity);
    }

    public ArrayStackImpl() {
        array = new ArrayImpl<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] Top");
        return res.toString();
    }
}
