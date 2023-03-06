/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
     * 迭代思路简单，递归思路不能一下想出来得看解释
     */
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // ListNode dummy = new ListNode();
    // ListNode cur = dummy;
    // while (list1 != null && list2 != null) {
    // if (list1.val > list2.val) {
    // cur.next = list2;
    // cur = list2;
    // list2 = list2.next;
    // } else {
    // cur.next = list1;
    // cur = list1;
    // list1 = list1.next;
    // }
    // }
    // if (list1 != null)
    // cur.next = list1;
    // else if (list2 != null)
    // cur.next = list2;
    // return dummy.next;
    // }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            ListNode subHead = mergeTwoLists(list1.next, list2);
            list1.next = subHead;
            return list1;
        } else {
            ListNode subHead = mergeTwoLists(list1, list2.next);
            list2.next = subHead;
            return list2;
        }
    }
}
// @lc code=end
