package com.sakura.queue;

/**
 * 1.3 基于1.1（数组）实现的队列
 */
public interface Queue<E> {

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 队首元素
     * @return
     */
    E getFront();

    /**
     * 队列长度
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();
}
