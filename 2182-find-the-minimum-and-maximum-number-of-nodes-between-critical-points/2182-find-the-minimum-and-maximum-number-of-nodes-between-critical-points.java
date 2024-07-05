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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        
        ListNode prev = head;
        if (prev == null) {
            return res;
        }
        ListNode curr = head.next;
        if (curr == null) {
            return res;
        }
        ListNode next = curr.next;
        if (next == null) {
            return res;
        }
        int minDist = Integer.MAX_VALUE;
        int firstDist = -1;
        int prevDist = -1;
        int i = 1;
        while (curr != null && next != null) {
            if (curr.val > next.val && curr.val > prev.val) {
                if (prevDist == -1) {
                    firstDist = i;
                    prevDist = i;
                } else {
                    minDist = Math.min(minDist, i-prevDist);
                    prevDist = i;
                }
            } else if (curr.val < next.val && curr.val < prev.val) {
                if (prevDist == -1) {
                    firstDist = i;
                    prevDist = i;
                } else {
                    minDist = Math.min(minDist, i-prevDist);
                    prevDist = i;
                }
            }
            prev = curr;
            curr = next;
            next = next.next;
            i++;
        }
        if (minDist == Integer.MAX_VALUE) {
            return res;
        }
        res[0] = minDist;
        res[1] = prevDist-firstDist;
        return res;
    }
}