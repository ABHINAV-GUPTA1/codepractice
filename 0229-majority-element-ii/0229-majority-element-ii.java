class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        int majorityElement1 = Integer.MIN_VALUE;
        int majorityCount1 = 0;

        int majorityElement2 = Integer.MIN_VALUE;
        int majorityCount2 = 0;

        int arrayLength = nums.length;

        for (int i = 0; i < arrayLength; i++) {
            if (nums[i] == majorityElement1) {
                majorityCount1++;
            } else if (nums[i] == majorityElement2) {
                majorityCount2++;
            } else if (majorityCount1 == 0) {
                majorityElement1 = nums[i];
                majorityCount1 = 1;
            } else if (majorityCount2 == 0) {
                majorityElement2 = nums[i];
                majorityCount2 = 1;
            } else {
                majorityCount1--;
                majorityCount2--;
            }
        }
        majorityCount1 = 0;
        majorityCount2 = 0;

        for (int i = 0; i < arrayLength; i++) {
            if (nums[i] == majorityElement1) {
                majorityCount1++;
            } else if (nums[i] == majorityElement2) {
                majorityCount2++;
            }
        }
        
        int reqTimes = (int) Math.floor(arrayLength / 3.0);
        if (majorityCount1 > reqTimes) {
            res.add(majorityElement1);
        }
        if (majorityCount2 > reqTimes) {
            res.add(majorityElement2);
        }

        return res;
    }
}