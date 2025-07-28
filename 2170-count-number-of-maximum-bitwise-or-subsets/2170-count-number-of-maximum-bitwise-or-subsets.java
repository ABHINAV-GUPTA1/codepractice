class Solution {
    Integer[][] dp;

    public int countMaxOrSubsets(int[] nums) {
        int maxor = 0;
        
        for (int i = 0; i < nums.length; i++) {
            maxor |= nums[i];
        }
        // dp = new Integer[nums.length + 1][maxor + 1];
        int[][] dpp = new int[nums.length + 1][maxor + 1];
        dpp[nums.length][maxor] = 1;
        for (int idx = nums.length - 1; idx >= 0; idx--) {
            for (int or = maxor; or >= 0; or--) {
                int ntake = dpp[idx + 1][or];
                int take = 0; 
                if ((or | nums[idx]) <= maxor) {
                    take = dpp[idx + 1][or | nums[idx]];
                }
                dpp[idx][or] = take + ntake;
            }
        }
        return dpp[0][0];
    }

    public int countMaxOrSubsets_method1(int[] nums) {
        int maxor = 0;
        
        for (int i = 0; i < nums.length; i++) {
            maxor |= nums[i];
        }
        dp = new Integer[nums.length][maxor + 1];
        return f(0, nums, 0, maxor);
    }

    private int f(int idx, int[] arr, int or, int maxor) {
        if (idx == arr.length) {
            if (or == maxor) {
                return 1;
            }

            return 0;
        }
        if (dp[idx][or] != null) {
            return dp[idx][or];
        }
        int ntake = f(idx + 1, arr, or, maxor);
        int take = f(idx + 1, arr, or | arr[idx], maxor);

        return dp[idx][or] = take + ntake;
    }}