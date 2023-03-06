/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = head;
        ListNode prev = null;
        int i;
        for (i = 1; i < left; i++) {
            prev = cur;
            cur = cur.next;
        }
        ListNode LR = prev; // 左侧未反转的最右边，可能是null
        ListNode subTail = cur; // 开始要翻转的第一个是翻转后的尾巴
        for (; i <= right; ++i) { // for 循环中翻转
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        subTail.next = cur; // 翻转后的子串的尾巴指向右边未翻转的地方
        if (LR != null) {
            LR.next = prev;
            return head;
        }
        return prev; // 如果左侧为空，就返回翻转后的子串的头

    }
}
// @lc code=end
