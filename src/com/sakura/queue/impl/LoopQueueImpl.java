package com.sakura.queue.impl;

import com.sakura.queue.Queue;

/**
 * 循环队列实现
 * @param <E>
 */
public class LoopQueueImpl<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueueImpl(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueueImpl() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder lookSb = new StringBuilder();
        lookSb.append(String.format("Queue: size: %d, capacity = %d\n", size, getCapacity()));
        lookSb.append("Front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            lookSb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                lookSb.append(", ");
            }
        }
        lookSb.append("] Tail");
        return lookSb.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for(int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}