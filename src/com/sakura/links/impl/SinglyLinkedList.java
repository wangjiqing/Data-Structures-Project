package com.sakura.links.impl;

import com.sakura.links.LinkedList;

/**
 * 1.4 链表的实现
 * @param <E>
 */
public class SinglyLinkedList<E> implements LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 虚拟头节点
     */
    private Node dummeyHead;
    int size;

    public SinglyLinkedList() {
        dummeyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表大小
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加一个元素到链表中
     * @param index
     * @param e
     */
    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummeyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size ++;
    }

    /**
     * 向链表第一个为止添加元素
     * @param e
     */
    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向链表最后一个为止添加一个元素
     * @param e
     */
    @Override
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 通过位置获取链表中的一个元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummeyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     * @return
     */
    @Override
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     * @return
     */
    @Override
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表指定位置的元素
     * @param index
     * @param e
     */
    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummeyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 判断元素是否存在在链表中
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        Node cur = dummeyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 移除一个位置的元素
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummeyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node detNode = prev.next;
        prev.next = detNode.next;
        detNode.next = null;
        size--;

        return detNode.e;
    }

    /**
     * 移除第一个元素
     * @return
     */
    @Override
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 移除最后一个元素
     * @return
     */
    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public void removeElement(E e) {
        Node prev = dummeyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("SinglyLinkedList: Head [ ");
        Node cur = dummeyHead.next;
        while (cur != null) {
            res.append(cur + " -> ");
            cur = cur.next;
        }
        res.append("NULL");
        res.append(" ]");

        return res.toString();
    }
}
