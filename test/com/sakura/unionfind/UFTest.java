package com.sakura.unionfind;

import com.sakura.unionfind.impl.UnionFindFour;
import com.sakura.unionfind.impl.UnionFindOne;
import com.sakura.unionfind.impl.UnionFindThree;
import com.sakura.unionfind.impl.UnionFindTwo;

import java.util.Random;

public class UFTest {

    private static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;
//        UF uf1 = new UnionFindOne(size);
//        System.out.println("UnionFind1: " + testUF(uf1, m) + " s");
//
//        UF uf2 = new UnionFindTwo(size);
//        System.out.println("UnionFind2: " + testUF(uf2, m) + " s");

        UF uf3 = new UnionFindThree(size);
        System.out.println("UnionFind3: " + testUF(uf3, m) + " s");

        UF uf4 = new UnionFindFour(size);
        System.out.println("UnionFind4: " + testUF(uf4, m) + " s");

        UF uf5 = new UnionFindFour(size);
        System.out.println("UnionFind5: " + testUF(uf5, m) + " s");

        UF uf6 = new UnionFindFour(size);
        System.out.println("UnionFind6: " + testUF(uf6, m) + " s");
    }
}
