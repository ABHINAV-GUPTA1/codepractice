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
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rev = reverse(slow);

        ListNode tl = head;
        while (tl != null && rev != null) {
            ListNode headNext = tl.next;
            ListNode revNext = rev.next;
            
            tl.next = rev;
            rev.next = headNext;
            
            tl = headNext;
            rev = revNext;
        }
        if (tl != null) {
            tl.next = null;
        }
        if (rev != null) {
            rev.next = null;
        }
    }

    public void reorderList1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rev = reverse(slow);

        ListNode tl = head;
        boolean add = true;
        ListNode ans = new ListNode (-1);
        ListNode res = ans;
        while (tl != null) {
            if (rev == null) {
                break;
            }
            if (add) {
                ans.next = tl;
                tl = tl.next;
            } else {
                ans.next = rev;
                rev = rev.next;
            }
            add = !add;
            ans = ans.next;
        }

        // print(res.next);
    }

    private void print(ListNode root) {
        while (root != null) {
            System.out.print(root.val+" ");
            root = root.next;
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