class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        int ansIdx = 0;
        while (idx < len) {
            if (!dq.isEmpty() && dq.peek() == idx - k) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[idx]) {
                dq.pollLast();
            }
            dq.offer(idx);
            if (idx - k + 1 >= 0) {
                ans[ansIdx++] = nums[dq.peek()];
            }
            idx++;
        }

        return ans;
    }
}