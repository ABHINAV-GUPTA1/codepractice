class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxFreq = 0;
        int ans = 0;
        int[] arr = new int[101];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
            if (arr[nums[i]] > maxFreq) {
                maxFreq = arr[nums[i]];
                ans = maxFreq;
            } else if (arr[nums[i]] == maxFreq) {
                ans += maxFreq;
            }
        }

        return ans;
    }
}