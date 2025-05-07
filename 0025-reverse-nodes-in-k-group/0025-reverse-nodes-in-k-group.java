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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
        while (temp != null) {
            ListNode kth = getKthNode(temp, k);
            if (kth == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }
            
            ListNode nextNode = kth.next;

            kth.next = null;
            ListNode rev = reverse(temp);
            if (head == temp) {
                head = kth;
            } else {
                prevLast.next = kth;
            }

            prevLast = temp;
            temp = nextNode;
        }

        return head;
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

    private ListNode getKthNode(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        k--;
        while (head != null && k-- > 0) {
            head = head.next;
        }
        return head;
    }
}