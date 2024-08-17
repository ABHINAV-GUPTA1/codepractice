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
        return merge(0, lists.length-1, lists);
    }

    private ListNode merge(int left, int right, ListNode[] arr) {
        if (left == right) {
            return arr[left];
        }
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        return mergeArr(merge(left, mid, arr), merge(mid+1, right, arr));
    } 

    private ListNode mergeArr(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ans.next = l2;
                l2 = l2.next;
            } else {
                ans.next = l1;
                l1 = l1.next;
            }
            ans = ans.next;
        }
        if (l1 != null) {
            ans.next = l1;
        }
        if (l2 != null) {
            ans.next = l2;
        }

        return res.next;
    }
}