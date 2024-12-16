class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        while (k-- > 0) {
            int[] val = pq.poll();
            val[0] *= multiplier;
            pq.offer(val);
            nums[val[1]] = val[0];
        }
        return nums;
    }
}