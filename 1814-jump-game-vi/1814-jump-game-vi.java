class Solution {
    public int maxResult(int[] nums, int k) {
        int max = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        pq.offer(new int[]{0, max});

        for (int i = 1; i < nums.length; i++) {
            while (!pq.isEmpty() && i - pq.peek()[0] > k) {
                pq.poll();
            }
            max = nums[i] + pq.peek()[1];
            pq.offer(new int[]{i, max});
        }

        return max;
    }
}