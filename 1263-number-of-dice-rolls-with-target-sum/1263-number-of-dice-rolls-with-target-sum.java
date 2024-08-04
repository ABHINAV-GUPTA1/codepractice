class Solution {
    
    int mod = 1000000007;
    
    public int numRollsToTarget(int n, int k, int target) {
        
        int[][] arr = new int[n+1][target+1];
        Arrays.stream(arr).forEach(a->Arrays.fill(a, -1));
        return helper(0, n, k, target, arr);
    }
    
    private int helper(int i, int n, int k, int target, int[][] arr) {
        if (i == n) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        
        if (arr[i][target] != -1) {
            return arr[i][target];
        }
        int ans = 0;
        for (int idx = 1; idx <= k; idx++) {
            if (idx <= target) {
                ans = (ans+ helper(i+1, n, k, target-idx, arr)%mod)%mod;
            }
        }
        
        return arr[i][target]=ans%mod;
    }
}