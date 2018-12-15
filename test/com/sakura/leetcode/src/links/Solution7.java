package com.sakura.leetcode.src.links;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 */
public class Solution7 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Queue<Integer> query = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (int key : map.keySet()) {
            if (query.size() < k) {
                query.add(key);
            } else if (map.get(key) > map.get(query.peek())){
                query.poll();
                query.add(key);
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!query.isEmpty()) {
            res.add(query.poll());
        }
        return res;
    }
}
