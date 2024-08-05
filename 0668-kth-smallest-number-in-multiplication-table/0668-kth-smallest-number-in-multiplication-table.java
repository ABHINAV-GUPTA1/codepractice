class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 0;
        int high = m*n;
        while (low <= high) {
            int mid = low+ (high-low) / 2;
            if (countOfElem(mid, m, n) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    int countOfElem(int mid, int m, int n) {
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += Math.min(mid/i, n);
        }

        return ans;
    }
}