class Solution {
    public int maxFrequency(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        
        /**Method 1
            Binary Search
         
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i-1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, getFreqForCurr(i, k, nums, preSum));
        }
        */
        /**
            Method 2
            Sliding window
        */
        long currSum = 0;
        int left = 0, targetIdx;
        long target;
        for (int right = 0; right < n; right++) {
            targetIdx = right;
            currSum += nums[targetIdx];
            // int cnt = (targetIdx - left + 1);
            // int wsum = cnt*nums[targetIdx];
            target = nums[targetIdx];
            while ((targetIdx - left + 1)*target - currSum > k) {
                currSum -= nums[left++];
            }
            res = Math.max(res, targetIdx - left + 1);
        }

        return res;
    }

    private int getFreqForCurr(int targetIdx, int k, int[] nums, int[] pre) {
        int i = 0;
        int j = targetIdx;
        int res = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int currWindowSum = pre[targetIdx] - pre[mid] + nums[mid];
            int cnt = targetIdx - mid + 1;
            int targetSum = cnt * nums[targetIdx];
            int ops = targetSum - currWindowSum;
            if (ops > k) {
                i = mid + 1;
            } else {
                res = mid;
                j = mid - 1;
            }
        }

        return targetIdx - res + 1;
    }
}