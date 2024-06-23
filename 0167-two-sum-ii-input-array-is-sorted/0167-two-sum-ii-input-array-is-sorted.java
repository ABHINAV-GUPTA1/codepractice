class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int left = 0;
        int right = numbers.length - 1;
        int k = 0;
        while (left < right) {
            k = numbers[left] + numbers[right];
            if (k == target) {
                return new int[]{left+1, right+1};
            }
            if (k > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] {-1,-1};
    }
}