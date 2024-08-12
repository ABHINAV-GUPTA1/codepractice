class Solution {
    int totalSum;
    public int maxSubarraySumCircular(int[] nums) {
        totalSum = 0;
        int maxSum = maxSubarray(nums);
        int minSum = minSubarray(nums);

        if (maxSum > 0) {
            return Math.max(maxSum, totalSum - minSum);
        }
        return maxSum;
    }

    private int maxSubarray(int[] arr) {
        int sum = arr[0];
        int max = arr[0];
        totalSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            totalSum += arr[i];
            sum = Math.max(arr[i]+sum, arr[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    private int minSubarray(int[] arr) {
        int sum = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.min(arr[i]+sum, arr[i]);
            min = Math.min(min, sum);
        }
        return min;
    }
}