class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (leftmax < height[left]) {
                    leftmax = height[left];
                } else {
                    ans+=leftmax-height[left];
                }
                left++;
            } else {
                if (rightmax < height[right]) {
                    rightmax = height[right];
                } else {
                    ans+=rightmax-height[right];
                }
                right--;
            }
        }
        return ans;
    }
}