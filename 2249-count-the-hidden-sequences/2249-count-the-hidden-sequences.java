class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int curr = 0;
        int minVal = 0;
        int maxVal = 0;
        int n = differences.length;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            curr = curr + differences[i];
            minVal = Math.min(curr, minVal);
            maxVal = Math.max(curr, maxVal);
            diff = (upper - maxVal) - (lower - minVal) + 1;
            if (diff <= 0) {
                return 0;
            }
        }    
        return diff;
    }
}