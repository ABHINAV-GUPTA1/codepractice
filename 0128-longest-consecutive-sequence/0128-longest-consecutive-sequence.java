class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 1;
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
        }    

        int idx = 0;
        while (idx < length) {
            if (!set.contains(nums[idx]-1)) {
                int curr = nums[idx];
                int count = 1;
                while (set.contains(curr+1)) {
                    set.remove(curr+1);
                    curr++;
                    count++;
                }
                ans = Math.max(ans, count);
            }
            idx++;
        }
        return ans;
    }
}