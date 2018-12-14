package com.sakura.heap;

import com.sakura.array.Array;
import com.sakura.array.impl.ArrayImpl;

/**
 * 基于动态数组实现的最大堆
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayImpl<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayImpl<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 堆中元素的上浮
     * @param k
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 移除最大元素
     * @return
     */
    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);

        return ret;
    }

    /**
     * 堆中元素的下沉
     * @param k
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            // data[j] 是 leftChild 和 rightChild 中最大值
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            } else {
                data.swap(k, j);
                k = j;
            }
        }
    }

    /**
     * 查找最大元素
     * @return
     */
    public E findMax() {
        if (!data.isEmpty()) {
            return data.get(0);
        }
        throw new IllegalArgumentException("Can not findMax when heap is empty");
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    /**
     * heapify
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new ArrayImpl<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 返回完全二叉堆的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent node");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树中的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    public int rightChild(int index) {
        return index * 2 + 2;
    }
}
