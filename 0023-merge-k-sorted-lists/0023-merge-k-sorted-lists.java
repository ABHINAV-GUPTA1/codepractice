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
        return mergeArr(0, lists.length-1, lists);    
    }

    private ListNode mergeArr(int left, int right, ListNode[] arr) {
        if (left == right) {
            return arr[left];
        }
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        return merge(mergeArr(left, mid, arr), mergeArr(mid+1, right, arr));
    } 

    private ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode ans = new ListNode(-1);
        ListNode tmp = ans;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tmp.next = a;
                a = a.next;
            } else {
                tmp.next = b;
                b = b.next;
            }
            tmp = tmp.next;
        }
        if (a != null) {
            tmp.next = a;
        }
        if (b != null) {
            tmp.next = b;
        }
        return ans.next;
    }




}