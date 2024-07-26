class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int[] ans = new int[n];
        int k = n-1;
        int v1, v2;
        while (i <= j) {
            v1 = nums[i]*nums[i];
            v2 = nums[j]*nums[j];
            if (v1 > v2) {
                ans[k--] = v1;
                i++;
            } else {
                ans[k--] = v2;
                j--;
            }
        }
        return ans;
    }
}