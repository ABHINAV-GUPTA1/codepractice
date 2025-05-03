class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        int pre = nums[0];
        int length = nums.length;
        int[] res = new int[length];
        res[0] = 1;
        
        for (int i = 1; i < length; i++) {
            res[i] = pre;
            pre = pre * nums[i];
        }

        int post = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            res[i] = res[i] * post;
            post = post * nums[i];
        }

        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        int length = nums.length;
        int[] pre = new int[length];
        int[] post = new int[length];
        pre[0] = nums[0];
        for (int i = 1; i < length; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }    
        post[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i];
        }
        int[] ans = new int[length];
        ans[0] = post[1];
        for (int i = 1; i < length-1; i++) {
            ans[i] = pre[i-1]*post[i+1];
        }
        ans[length - 1] = pre[length - 2];
        return ans;
    }
}