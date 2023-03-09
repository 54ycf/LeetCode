/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    /*
     * base做法是将列表存到数组中操作，空间复杂度On
     * 
     * 可以先找到中点，再翻转末尾，再左右两部分合并
     */
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;// 用快慢指针找到中点
            fast = fast.next.next;
        }
        // slow是中点，从slow开始往下翻转链表
        ListNode prev = null;
        ListNode cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // 交叉组合
        ListNode left = head, right = prev;
        while (true) {
            ListNode lNext = left.next;
            if (left == right || lNext == right)
                break;
            left.next = right;
            left = lNext;

            ListNode rNext = right.next;
            right.next = lNext;
            right = rNext;
        }
    }
}
// @lc code=end
