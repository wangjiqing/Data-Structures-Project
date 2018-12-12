package com.sakura.array.impl;

import com.sakura.array.Array;

public class ArrayImpl<E> implements Array<E> {

    /* 使用private，符合类的封装性，避免属性不一致 */
    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public ArrayImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 无参构造函数，默认数组的容量capacity为10
     */
    public ArrayImpl() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getCapacity() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index gt 0 and index elt size.");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is Illegal.");
        }
        return data[index];
    }

    @Override
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public E getFirst() {
        return get(0);
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is Illegal.");
        }
        data[index] = e;
    }

    @Override
    public boolean contains(E e) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed. index gt 0 and index elt size.");
        } else {
            E e = get(index);

            for (int i = index + 1; i < size; i++) {
                data[i - 1] = data[i];
            }
            size--;
            data[size] = null; // 可以触发Java语言的垃圾回收 loitering objects != memory leak(内存泄漏)

            if (size ==data.length / 4 && data.length / 2 != 0) {
                resize(data.length / 2);
            }
            return e;
        }
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public int removeElement(E e) {
        int index = find(e);
        if (index == -1) {
            throw new IllegalArgumentException("remove failed. No element exists.");
        } else {
            remove(index);
        }
        return index;
    }

    @Override
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    /**
     * 数组的扩容
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] data = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            data[i] = this.data[i];
        }
        this.data = data;
    }
}
