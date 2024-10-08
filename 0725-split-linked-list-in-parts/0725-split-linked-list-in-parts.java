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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];
        int len = 0;
        for (ListNode root = head; root != null; root = root.next) {
            len++;
        }

        int n = len / k;
        int r = len % k;
        ListNode node = head, prev = null;
        for (int i = 0; node != null && i < k; i++, r--) {
            parts[i] = node;
            int size = n + (r > 0 ? 1 : 0);
            for (int j = 0; j < size; j++) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }

        return parts;
    }
}