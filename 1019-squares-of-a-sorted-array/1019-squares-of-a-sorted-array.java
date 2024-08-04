class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        if (n < 1) {
            return nums;
        }
        int[] res = new int[n];

        int i = 0;
        int j = n-1;
        int k = n-1;
        int v1 = nums[i]*nums[i];
        int v2 = nums[j]*nums[j];
        while (i <= j) {
            if (v1 > v2) {
                res[k--] = v1;
                i++;
                if (i <= j) {
                    v1 = nums[i] * nums[i];
                }
            } else {
                res[k--] = v2;
                j--;
                if (i <= j) {
                    v2 = nums[j]*nums[j];
                }
            }
        }
        return res;
    }
}