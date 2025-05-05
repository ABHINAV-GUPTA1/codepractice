class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int ele = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek(); 
                ans = Math.max(ans, heights[ele] * (nse - pse - 1));
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int ele = st.pop();
            int nse = heights.length;
            int pse = st.isEmpty() ? -1 : st.peek();
            ans = Math.max(ans, heights[ele] * (nse - pse - 1));
        }

        return ans;
    }
}