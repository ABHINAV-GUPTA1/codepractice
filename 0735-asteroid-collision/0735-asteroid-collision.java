class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
                continue;
            }
            int val = Math.abs(arr[i]);
            while (!st.isEmpty() && arr[st.peek()] < val && arr[i] < 0 && arr[st.peek()] > 0) {
                st.pop();
            }
            if (!st.isEmpty() && arr[st.peek()] == val && arr[i] < 0 && arr[st.peek()] > 0) {
                st.pop();
                continue;
            }
            if (!st.isEmpty() && arr[st.peek()] > val && arr[i] < 0 && arr[st.peek()] > 0) {
                continue;
            }
            st.push(i);

        }
        int n = st.size();
        int[] res = new int[n];
        while (!st.isEmpty()) {
            res[--n] = arr[st.pop()];
        }
        return res;
    }
}