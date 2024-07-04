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
    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        int sum = 0;
        while (head != null) {
            if (head.val == 0) {
                if (sum == 0) {
                    head = head.next;
                } else {
                    ans.next = new ListNode(sum);
                    sum = 0;
                    ans = ans.next;
                }
            } else {
                sum += head.val;
                head = head.next;
            }
        }

        return res.next;
    }
}