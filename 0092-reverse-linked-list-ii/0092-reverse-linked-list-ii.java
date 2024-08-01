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
        if (left == right) {
            return  head;
        }
        ListNode ans = new ListNode(-1);
        ListNode res = ans;
        ListNode rev = null;
        for (int i = 1;;i++) {
            if (i < left) {
                res.next = head;
                res = res.next;
            } else {
                break;
            }
            
            head = head.next;
        }
        rev = head;
        // System.out.println("head.val="+head.val);
        for (int i = left; i < right && head != null; i++) {
            head = head.next;
        }
        // System.out.println("head2.val="+head.val);
        ListNode next = head.next;
        head.next = null;
        ListNode t1 = rev;

        rev = reverse(rev);
        res.next = rev;
        // System.out.println("t1.val="+t1.val);
        t1.next = next;
        return ans.next;

    }

    ListNode reverse(ListNode curr) {
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