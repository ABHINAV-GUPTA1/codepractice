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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        while (head != null) {
            if (!set.contains(head.val)) {
                ans.next = head;
                ans = ans.next;
            }
            head = head.next;
        }
        ans.next = null;
        return res.next;
    }
}