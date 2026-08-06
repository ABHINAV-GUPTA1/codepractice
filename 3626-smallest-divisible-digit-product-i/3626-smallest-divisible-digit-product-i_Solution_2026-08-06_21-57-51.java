class Solution {
    public int smallestNumber(int n, int t) {
        return (((n % 10) % t) == 0) ? n : n + 1;
    }
}