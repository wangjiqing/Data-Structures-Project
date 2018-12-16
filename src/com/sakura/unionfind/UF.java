package com.sakura.unionfind;

/**
 * 并查集
 */
public interface UF {

    int getSize();

    /**
     * 是否属于同一集合
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 合并
     * @param p
     * @param q
     */
    void unionElements(int p, int q);
}
