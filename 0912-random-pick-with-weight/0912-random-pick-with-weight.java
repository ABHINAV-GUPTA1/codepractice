class Solution {
    int[] presum;
    int n;
    Random random;
    public Solution(int[] arr) {
        n = arr.length;
        random = new Random();
        presum = new int[n];
        presum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            presum[i] = presum[i-1] + arr[i];
        }
    }
    
    public int pickIndex() {
        int l = 0;
        int h = n-1;
        int target = 1 + random.nextInt(presum[h]);
        while (l <= h) {
            int mid = l + (h-l)/2;
            if (presum[mid] == target) {
                return mid;
            }
            if (presum[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */