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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }

        int i = 0, j = 0;
        int minrow = 0;
        int mincol = 0; 
        int maxrow = m-1;
        int maxcol = n-1;
        while (head != null) {
            for (int k = mincol; k <= maxcol && head != null; k++) {
                res[minrow][k] = head.val;
                head = head.next;
            }
            minrow++;
            for (int k = minrow; k <= maxrow && head != null; k++) {
                res[k][maxcol] = head.val;
                head = head.next;
            }
            maxcol--;
            for (int k = maxcol; k >= mincol && head != null; k--) {
                res[maxrow][k] = head.val;
                head = head.next;
            }
            maxrow--;
            for (int k = maxrow; k >= minrow && head != null; k--) {
                res[k][mincol] = head.val;
                head = head.next;
            }
            mincol++;
        }
        return res;
    }
}