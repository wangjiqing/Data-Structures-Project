package com.sakura.leetcode.src.links;

/**
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * 使用虚拟头节点
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        // 创建一个虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution2().removeElements(head, 6);
        System.out.println(res);
    }
}
