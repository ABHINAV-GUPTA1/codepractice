class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] maxright = new int[n];
        maxright[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            maxright[i] = Math.max(maxright[i+1], nums[i]);
        }
        int res = 0;
        int l = 0;
        int r = 0;
        while (r < n) {
            while (l < n && nums[l] > maxright[r]) {
                l++;
            }
            res = Math.max(res, r-l);
            r++;
        }

        return res;
    }
}