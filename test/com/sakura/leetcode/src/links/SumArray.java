package com.sakura.leetcode.src.links;

/**
 * 使用递归数组求和实例
 */
public class SumArray {

    private static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算arr[l .. n) 这个区间内所有数组的和
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {  // 在这里跳出递归循环
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(arr));
    }
}
