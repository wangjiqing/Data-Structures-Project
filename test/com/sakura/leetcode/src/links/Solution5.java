package com.sakura.leetcode.src.links;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * leetcode 349
 */
public class Solution5 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>();

        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
