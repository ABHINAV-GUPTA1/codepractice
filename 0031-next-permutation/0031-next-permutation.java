class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = n-1;
        while (idx >= 0) {
            if (idx > 0 && nums[idx] > nums[idx-1]) {
                idx--;
                break;
            }
            idx--;
        }
        
        if (idx == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        int val = idx;
        idx = n-1;
        while (idx > val) {
            if (nums[idx] > nums[val]) {
                swap(nums, idx, val);
                break;
            }
            idx--;
        }

        reverse(nums, val+1, n-1);

    }
    
    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}