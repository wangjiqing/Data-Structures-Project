package com.sakura.map.impl;

import com.sakura.map.Map;
import com.sakura.tree.avl.AvlTree;

/**
 * 基于avlTree实现的Map
 * @param <K>
 * @param <V>
 */
public class AvlMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AvlTree<K, V> avl;

    public AvlMap() {
        avl = new AvlTree<>();
    }


    @Override
    public void add(K key, V value) {
        avl.add(key, value);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void set(K key, V value) {
        avl.set(key, value);
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
