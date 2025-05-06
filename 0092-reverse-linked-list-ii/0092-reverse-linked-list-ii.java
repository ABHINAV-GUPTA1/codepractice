/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode res = new ListNode(-1);
        ListNode ans = res;

        for (int i = 1; i < left; i++) {
            res.next = head;
            head = head.next;
            res = res.next;
        }
        ListNode rev = head;
        ListNode curr = head, next = null, prev = null;
        while (curr != null && left <= right) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            left++;
        }

        res.next = prev;
        rev.next = curr;

        return ans.next;
    }
}