class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        int head = 0, tail = 0;
        while (tail < n) {
            head = Math.max(head, map.getOrDefault(nums[tail], -1) + 1);

            int tailSum = preSum[tail];
            int headSum = head - 1 < 0 ? 0 : preSum[head - 1];

            ans = Math.max(ans, tailSum - headSum);
            map.put(nums[tail], tail);
            tail++;
        }

        return ans;

    }
}