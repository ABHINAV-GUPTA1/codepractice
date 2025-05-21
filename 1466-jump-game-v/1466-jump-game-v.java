class Solution {

    public int maxJumps(int[] arr, int d) {
        int res = 0;
        // dp = new Integer[arr.length];
        int[] dp = new int[arr.length];
        List<Integer> index = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            index.add(i);
        }

        index.sort((i, j) -> Integer.compare(arr[i], arr[j]));

        for (int idx : index) {
            int ans = 1;
            for (int i = idx - 1; i >= Math.max(idx - d, 0) && arr[idx] > arr[i]; i--) {
                ans = Math.max(ans, 1 + dp[i]);
            }

            for (int i = idx + 1; i <= Math.min(idx + d, arr.length - 1) && arr[idx] > arr[i]; i++) {
                ans = Math.max(ans, 1 + dp[i]);
            }

            dp[idx] = ans;
            res = Math.max(res, dp[idx]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }

    /**
        Method 1 : Recursion + memoization
     */
    Integer[] dp;
    public int maxJumps_method1(int[] arr, int d) {
        int ans = 0;
        dp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, f(arr, i, d));
        }
        return ans;
    }

    private int f(int[] arr, int idx, int d) {
        if (dp[idx] != null) {
            return dp[idx];
        }
        int ans = 1;
        for (int i = idx - 1; i >= Math.max(idx - d, 0) && arr[idx] > arr[i]; i--) {
            ans = Math.max(ans, 1 + f(arr, i, d));
        }

        for (int i = idx + 1; i <= Math.min(idx + d, arr.length - 1) && arr[idx] > arr[i]; i++) {
            ans = Math.max(ans, 1 + f(arr, i, d));
        }

        return dp[idx] = ans;
    }
}