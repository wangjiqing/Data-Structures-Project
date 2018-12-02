package com.sakura.stack;

/**
 * 1.2 基于1.1（封装数组）封装栈
 * @param <E>
 */
public interface Stack<E> {

    /**
     * 栈的大小
     * @return
     */
    int getSize();

    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 向栈中添加元素
     * @param e
     */
    void push(E e);

    /**
     * 从栈中取出元素
     * @return
     */
    E pop();

    /**
     * 查看栈顶的元素
     * @return
     */
    E peek();
}
