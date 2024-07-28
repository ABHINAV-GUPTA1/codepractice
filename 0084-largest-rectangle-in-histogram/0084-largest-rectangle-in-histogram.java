class Solution {
    
    
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length; 
        int ans = 0;
        int width, height;
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {
                height = heights[st.pop()];
                if (st.isEmpty()) {
                    width = i;
                } else {
                    width = i - st.peek()-1;
                }
                // System.out.println("i="+i+" ht="+height+" Width="+width);
                ans = Math.max(height*width, ans);
            }
            st.push(i);
        }

        return ans;
    }

    public int largestRectangleArea1(int[] heights) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                leftSmaller[i] = 0;
            } else {
                leftSmaller[i] = st.peek() + 1;
            }
            st.push(i);
        }
        st.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rightSmaller[i] = n-1;
            } else {
                rightSmaller[i] = st.peek() - 1;
            }
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max((rightSmaller[i] - leftSmaller[i] + 1) * heights[i], ans);
        }
        return ans;
    }
}