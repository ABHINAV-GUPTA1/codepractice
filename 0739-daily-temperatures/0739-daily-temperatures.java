class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int length = temperatures.length;
        int[] res = new int[length];    
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = length - 1; i >= 0; i--) {
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
        }

        return res;
    }
}