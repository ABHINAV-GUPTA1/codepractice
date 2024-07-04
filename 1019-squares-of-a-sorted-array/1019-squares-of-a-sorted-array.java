class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int k = n-1;
        int[] ans = new int[n];
        int v1,v2;
        while (k >= 0) {
            v1 = nums[i]*nums[i];
            v2 = nums[j] * nums[j];
            if (v1 > v2) {
                ans[k] = v1;
                i++;
            } else {
                ans[k] = v2;
                j--;
            }
            k--;
        }
        return ans;
    }
}