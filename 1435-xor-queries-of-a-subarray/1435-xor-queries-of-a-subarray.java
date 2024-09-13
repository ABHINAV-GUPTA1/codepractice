class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXor = new int[n];
        prefixXor[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i-1] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (u == 0) {
                ans[i] = prefixXor[v];
            } else {
                ans[i] = prefixXor[u-1] ^ prefixXor[v];
            }
        }
        return ans;
    }
}