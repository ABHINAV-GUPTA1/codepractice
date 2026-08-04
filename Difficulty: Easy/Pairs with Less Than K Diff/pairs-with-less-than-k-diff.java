class Solution {
    public static int countPairs(int arr[], int k) {
        // code here
        Arrays.sort(arr);
        int ans = 0;
        int right = 0;
        for (int left = 0; left < arr.length; left++) {
            while (arr[left] - arr[right] >= k) {
                right++;
            }
            
            ans += (left - right);
        }
        
        return ans;
    }
}
