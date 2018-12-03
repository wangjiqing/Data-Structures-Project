package com.sakura.queue.impl;

import com.sakura.array.Array;
import com.sakura.array.impl.ArrayImpl;
import com.sakura.queue.Queue;

public class ArrayQueueImpl<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueueImpl(int capacity) {
        this.array = new ArrayImpl<>(capacity);
    }

    public ArrayQueueImpl() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder qres = new StringBuilder();
        qres.append(String.format("Queue: "));
        qres.append("Front [");
        for (int i = 0; i < array.getSize(); i++) {
            qres.append(array.get(i));
            if (i != array.getSize() - 1) {
                qres.append(", ");
            }
        }
        qres.append("] Tail");
        return qres.toString();
    }
}
