package com.sakura.unionfind.impl;

import com.sakura.unionfind.UF;

public class UnionFindFour implements UF {
    private int[] parent;
    private int[] rank;   // rank[i] 表示以i为根的集合所表示的树的层数

    public UnionFindFour(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] == qRoot) {
            parent[qRoot] = pRoot;
        } else {    // sz[qRoot] <= sz[pRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    // 查找过程，查找元素p所对应的集合编号
    // O(h)复杂度，h为树的高度
    private int find(int p) {
        if (p < 0 && p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }

        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
