class Solution {
    
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        
        sum = Arrays.stream(nums).sum();
        
        if (sum % 2 == 1) {
            return false;
        }
        
        sum /= 2;
        
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];
        prev[0] = true;
        if (nums[0] <= sum) {
            prev[nums[0]] = true;
        }
        for (int idx = 1; idx < nums.length; idx++) {
            for (int k = 1; k <= sum; k++) {
                boolean ntake = prev[k];
                boolean take = false;
                if (k >= nums[idx]) {
                    take = prev[k - nums[idx]];
                }

                curr[k] = take || ntake;
            }
            prev = Arrays.copyOf(curr, curr.length);
        }
        return prev[sum];
    }

    public boolean canPartition_method2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        
        sum = Arrays.stream(nums).sum();
        
        if (sum % 2 == 1) {
            return false;
        }
        
        sum /= 2;
        boolean[][] dp = new boolean[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true; 
        }
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }
        for (int idx = 1; idx < nums.length; idx++) {
            for (int k = 1; k <= sum; k++) {
                boolean ntake = dp[idx - 1][k];
                boolean take = false;
                if (k >= nums[idx]) {
                    take = dp[idx - 1][k - nums[idx]];
                }

                dp[idx][k] = take || ntake;
            }
        }
        return dp[nums.length - 1][sum];
    }
    
    public boolean canPartition_method1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        
        sum = Arrays.stream(nums).sum();
        
        if (sum % 2 == 1) {
            return false;
        }
        
        sum /= 2;

        return f(nums, nums.length - 1, sum);

    }

    private boolean f(int[] arr, int idx, int k) {
        if (k == 0) {
            return true;
        }
        if (idx == 0) {
            return arr[idx] == k;
        }
        boolean ntake = f(arr, idx - 1, k);
        boolean take = false;
        if (k >= arr[idx]) {
            take = f(arr, idx - 1, k - arr[idx]);
        }

        return take || ntake;
    }
}