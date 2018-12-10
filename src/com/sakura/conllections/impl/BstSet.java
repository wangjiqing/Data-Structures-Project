package com.sakura.conllections.impl;

import com.sakura.conllections.Set;
import com.sakura.tree.bst.Bst;

/**
 * 基于二分搜索树实现的Set集合类
 * @param <E>
 */
public class BstSet<E extends Comparable<E>> implements Set<E> {

    private Bst<E> bst;

    public BstSet() {
        bst = new Bst<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
