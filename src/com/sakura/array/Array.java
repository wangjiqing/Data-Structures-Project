package com.sakura.array;

/**
 * 1.1 封装数组
 */
public interface Array<E> {

    /**
     * 获取数组中的元素个数
     * @return
     */
    int getSize();

    /**
     * 获取数组的容量
     * @return
     */
    int getCapacity();

    /**
     * 判断数组是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 向数组中指定的index添加元素
     * @param index
     * @param e
     */
    void add(int index, E e);

    /**
     * 向数组最后一个位置添加一个新的元素
     * @param e
     */
    void addLast(E e);

    /**
     * 向数组第一个位置添加一个新的元素
     * @param e
     */
    void addFirst(E e);

    /**
     * 获取指定index位置的元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 获取数组中最后一个元素
     * @return
     */
    E getLast();

    /**
     * 获取数组中的第一个元素
     * @return
     */
    E getFirst();

    /**
     * 修改index位置的元素
     * @param index
     * @param e
     */
    void set(int index, E e);

    /**
     * 查找数组中是否包含一个元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 查找数组中元素e所在的第一个索引，如果不存在元素e,返回-1
     * @param e
     * @return
     */
    int find(E e);

    /**
     * 删除指定index位置的元素，返回删除的元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 删除数组中的第一个元素，返回删除的元素
     * @return
     */
    E removeFirst();

    /**
     * 删除数组中的最后一个元素，返回删除的元素
     * @return
     */
    E removeLast();

    /**
     * 删除一个元素e，返回删除元素所在的index的第一个出现的位置
     * @param e
     * @return
     */
    int removeElement(E e);
}