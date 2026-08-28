public class Solution {
    /**
     * @param n: a number
     * @param d: digit needed to be rorated
     * @return: a number
     */
    public int leftRotate(int n, int d) {
        // write code here
        return (n << d) | (n >> (32 - d));
    }
}