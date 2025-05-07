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
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists, 0, lists.length - 1);
    }

    private ListNode mergeList(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        return mergeArr(mergeList(lists, left, mid), mergeList(lists, mid + 1, right));
    }

    private ListNode mergeArr(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode res = ans;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ans.next = l1;
                l1 = l1.next;
            } else {
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }

        while (l1 != null) {
            ans.next = l1;
            l1 = l1.next;
            ans = ans.next;
        }

        while (l2 != null) {
            ans.next = l2;
            l2 = l2.next;
            ans = ans.next;
        }

        return res.next;
        
    }
}