class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long curr = 0;
        long minVal = 0;
        long maxVal = 0;
        int n = differences.length;
        long diff;
        
        for (int i = 0; i < n; i++) {
            curr = curr + differences[i];
            minVal = Math.min(curr, minVal);
            maxVal = Math.max(curr, maxVal);
        }
        
        diff = (upper - maxVal) - (lower - minVal) + 1;
        
        return diff <= 0 ? 0 : (int) diff;
    }
}