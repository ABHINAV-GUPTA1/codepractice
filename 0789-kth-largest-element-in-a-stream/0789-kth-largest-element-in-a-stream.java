class KthLargest {

    PriorityQueue<Integer> pq;
    int size = 0;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k+1);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        size = k;
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > size) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */