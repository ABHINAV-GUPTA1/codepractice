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
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow); // reverse half part
        ListNode t1 = head;
        while (t1 != null && rev != null) {
            ListNode headnext = t1.next;
            ListNode revnext = rev.next;

            t1.next = rev;
            rev.next = headnext;

            t1 = headnext;
            rev = revnext;
        }

        if (t1 != null) {
            t1.next = null;
        }
        if (rev != null) {
            rev.next = null;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}