public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if ( nums == null || nums.length == 0 )  {
            return 0;
        }
        
        
        int sum               = 0; 
        int prefixSumMinSoFar = 0; 
        int result            = Integer.MIN_VALUE;

        for ( int i = 0; i < nums.length; i++ ) {
            sum              += nums[i];
            result            = Math.max(result, sum - prefixSumMinSoFar); 
            prefixSumMinSoFar = Math.min(prefixSumMinSoFar, sum); 
        }
        
        return result;
    }
}