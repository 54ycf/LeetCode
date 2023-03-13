/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }
    /*
     * 有几个注意的地方，一个是mid，继续sort递归的时候是head mid mid tail，即上闭下开
     * 还有就是head.next = tail的时候，head的next要设为空，否则merge不下来
     */

    private ListNode sort(ListNode head, ListNode tail) {
        if(head==null)
            return null;
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode mid = middle(head, tail);
        ListNode list1 = sort(head, mid);
        ListNode list2 = sort(mid, tail);
        return merge(list1, list2);
    }

    private ListNode middle(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }
}
// @lc code=end
