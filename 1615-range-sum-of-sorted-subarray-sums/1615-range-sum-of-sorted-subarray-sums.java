class Solution {
    int mod = (int)1e9 + 7;
    public int rangeSum(int[] nums, int n, int left, int right) {
        int ans = 0;
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0])); // sum, index => sorted by sum
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i}); // T(n) => n(log n) {n-> elements, log n for each push in que} 
        }

        for (int i = 1; i <= right && !pq.isEmpty(); i++) {
            int[] arr = pq.poll();
            int sum = arr[0];
            int idx = arr[1];
            
            if (i >= left) {
                ans = (ans+sum)%mod;
            }
            if (idx+1 < n) {
                arr[0] = (sum + nums[idx+1])%mod;
                arr[1] = idx + 1;
                pq.offer(arr);
            }
        }

        return ans;
    }
}