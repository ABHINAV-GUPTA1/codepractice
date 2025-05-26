// User function Template for Java

class Solution {
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int tar) {
        int currsum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            currsum += arr[i];
            
            if (map.containsKey(currsum - tar)) {
                count+=map.get(currsum-tar);
            }
            map.put(currsum, map.getOrDefault(currsum, 0) + 1);
        }
        
        return count;
    }
}