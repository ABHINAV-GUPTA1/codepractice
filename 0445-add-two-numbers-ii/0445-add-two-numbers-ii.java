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
        int s1 = sizeof(l1);
        int s2 = sizeof(l2);
        ListNode res = null;
        ListNode ans = res;
        int sum = 0, v1, v2;
        while (s1 > 0 && s2 > 0) {
            if (s1 >= s2) {
                v1 = l1.val;
                l1 = l1.next;
                s1--;
            } else {
                v1 = 0;
            }
            if (s2 >= s1+1) {
                v2 = l2.val;
                l2 = l2.next;
                s2--;
            } else {
                v2 = 0;
            }
            sum = v1 + v2;;
            
            ListNode l = new ListNode(sum);
            l.next = res;
            res = l;
        }    
        ans = new ListNode (-1);
        ListNode tmp = ans;
        ListNode k1 = null;
        int carry = 0;
        while (res != null) {
            sum = res.val + carry;
            res.val = sum%10;
            if (sum < 10) {
                carry = 0;
            } else {
                carry = sum/10;
            }
            ans.next = res;
            res = res.next;
            ans.next.next = k1;
            k1 = ans.next;
        }

        if (carry > 0) {
            ans.next = new ListNode(carry);
            ans.next.next=k1;
        }

        return ans.next;
    }

    private int sizeof(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}