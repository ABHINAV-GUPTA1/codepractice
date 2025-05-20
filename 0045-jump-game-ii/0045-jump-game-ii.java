class Solution {

    /**
        Method 3 : space optimised
     */
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int jumps = 0;
        int len = nums.length;
        while (r < len - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }

    /**
        Method 2 : DP
     */
    public int jump_method2(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[nums.length - 1][i] = i;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 2; j >= 0; j--) {
                int min = Integer.MAX_VALUE;
                for (int idx = 1; idx <= nums[i] && (idx + i) < nums.length; idx++) {
                    
                    min = Math.min(min, dp[idx + i][j + 1]);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][0];
    }

    /**
        Method 1 : recursion
     */
    public int jump_method1(int[] nums) {
        return f(0, 0, nums);
    }

    private int f(int idx, int jumps, int[] arr) {
        if (idx >= arr.length - 1) {
            return jumps;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[idx]; i++) {
            min = Math.min(min, f(idx + i, jumps + 1, arr));
        }
        return min;
    }
}