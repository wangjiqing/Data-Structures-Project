package com.sakura.array;

import com.sakura.array.impl.ArrayImpl;

public class ArrayTest {

    public static void main(String[] args) {
        Array<String> arr = new ArrayImpl<>();

        System.out.println(arr.isEmpty());  // true

        arr.addLast("zhangsan");
        arr.addLast("lisi");
        arr.addLast("wangwu");

        System.out.println(arr);
        System.out.println(arr.isEmpty());  // false
    }
}
