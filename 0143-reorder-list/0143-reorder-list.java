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
    public void reorderList(ListNode head) {
        // step 1 find mid
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // step 2 reverse second half
        ListNode rev = reverse(slow);

        // step 3 connect the list

        ListNode  ans = head;
        ListNode tcurr, trev;
        while (rev.next != null) {
            tcurr = ans.next;
            trev = rev.next;

            ans.next = rev;
            rev.next = tcurr;

            ans = tcurr;
            rev = trev;
        }
    }

    private ListNode reverse(ListNode curr) {
        ListNode next = null, prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}