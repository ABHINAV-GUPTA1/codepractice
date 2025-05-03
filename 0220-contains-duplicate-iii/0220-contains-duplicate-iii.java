class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer ceiling = set.ceiling(num-valueDiff);
            if (ceiling != null && Math.abs(ceiling-num) <= valueDiff) {
                return true;
            }
            set.add(num);
            if (i >= indexDiff) {
                set.remove(nums[i-indexDiff]);
            }
        }
        return false;
    }
}