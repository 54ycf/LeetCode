/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode nxt = head.next;
        while (cur != null && nxt != null) {
            if (cur.val == nxt.val) {
                nxt = nxt.next;
            } else if (cur.next != nxt) {
                pre.next = nxt;
                cur = nxt;
                nxt = nxt.next;
            } else {
                pre = cur;
                cur = nxt;
                nxt = nxt.next;
            }
        }
        if (cur.next != nxt) {
            pre.next = null; //收尾，例如[1,1]，最后pre = dummy，cur = 第一个1，nxt = null
        }
        return dummy.next;
    }
}
// @lc code=end
