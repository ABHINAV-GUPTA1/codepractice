class Solution {
    public int missingNumber(int[] nums) {
        // int ans = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     ans ^= i;
        //     ans ^= nums[i];
        // }    
        // ans ^= nums.length;

        // return ans;

        int n = nums.length;
        int sum = n * (n+1) / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }

        return sum;

    }
}