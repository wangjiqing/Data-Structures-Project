package com.sakura.conllections.impl;

import com.sakura.conllections.Set;
import com.sakura.tree.avl.AvlTree;

/**
 * 基于AvlTree实现的Set
 * @param <E>
 */
public class AvlSet<E extends Comparable<E>> implements Set<E> {

    private AvlTree<E, Object> avl;

    public AvlSet() {
        avl = new AvlTree<>();
    }

    @Override
    public void add(E e) {
        avl.add(e, null);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
