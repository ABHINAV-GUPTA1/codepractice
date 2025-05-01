class Solution {
    /***
        abs(i - j) <= indexDiff
        arr[i] <= valueDiff + nums[j]
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            Long ceilingNumber = set.ceiling(num-valueDiff);
            if (ceilingNumber != null && Math.abs(ceilingNumber - num) <= valueDiff) {
                return true;
            }
            
            set.add(num);
            if (i >= indexDiff) {
                set.remove((long) nums[i-indexDiff]);
            }
        } 

        return false;
    }
}