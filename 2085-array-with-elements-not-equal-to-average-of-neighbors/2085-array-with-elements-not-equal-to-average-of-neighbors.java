class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int j = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i+=2) {
            ans[i] = nums[j++];
        }    
        for (int i = 1; i < n; i+=2) {
            ans[i] = nums[j++];
        }    

        return ans;
    }
}