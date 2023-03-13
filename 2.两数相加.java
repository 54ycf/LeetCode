/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
     * 用递归～
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int v1 = 0, v2 = 0;
        if (l1 != null) {
            v1 = l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            v2 = l2.val;
            l2 = l2.next;
        }
        int sum = v1 + v2 + carry;
        carry = sum / 10;
        int value = sum % 10;
        ListNode node = new ListNode(value);
        node.next = add(l1, l2, carry);
        return node;
    }
}
// @lc code=end
