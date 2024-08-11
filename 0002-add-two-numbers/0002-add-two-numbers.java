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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        ListNode p1 = l1, p2 = l2;
        int v1, v2;
        int carry = 0;
        while (p1 != null || p2 != null) {
            v1 = p1 == null ? 0 : p1.val;
            v2 = p2 == null ? 0 : p2.val;
            int sum = v1+v2+carry;
            carry = sum/10;
            ans.next = new ListNode(sum%10);
            ans = ans.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (carry > 0) {
            ans.next = new ListNode(carry);
        }
        return res.next;
    }
}