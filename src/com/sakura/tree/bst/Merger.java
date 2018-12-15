package com.sakura.tree.bst;

/**
 * 融合两个E元素
 * @param <E>
 */
public interface Merger<E> {
    E merge(E a, E b);
}
