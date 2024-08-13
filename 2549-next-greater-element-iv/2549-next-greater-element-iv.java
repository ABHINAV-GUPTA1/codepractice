class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> nums[a]-nums[b]);
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && nums[i] > nums[pq.peek()]) {
                ans[pq.poll()] = nums[i];
            }
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                pq.offer(st.pop());
            }
            st.push(i);
        }

        return ans;
    }
}