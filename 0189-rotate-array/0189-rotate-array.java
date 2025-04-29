class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        rotate(nums, 0, length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, length - 1);
    }

    private void rotate(int[] arr, int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}