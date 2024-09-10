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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev = head;
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        ans.next = head;
        head = head.next;
        // ListNode next = head;
        while (prev != null && head != null) {
            int val = gcd(prev.val, head.val);
            prev.next = new ListNode(val);
            prev.next.next = head;
            prev = head;
            head = head.next;
        }
        return ans.next;
    }

    public int gcd(int a,  int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
}