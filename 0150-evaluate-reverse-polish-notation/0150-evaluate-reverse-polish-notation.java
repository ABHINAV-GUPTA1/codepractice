class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;
        int a, b;
        char c;
        for (int i = 0; i < n; i++) {
            c = tokens[i].charAt(tokens[i].length()-1);
            if (c == '+') {
                b = st.pop();
                a = st.pop();
                st.push(a+b);
            } else if (c == '-') {
                b = st.pop();
                a = st.pop();
                st.push(a-b);
            } else if (c == '*') {
                b = st.pop();
                a = st.pop();
                st.push(a*b);
            } else if (c == '/') {
                b = st.pop();
                a = st.pop();
                st.push(a/b);
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }    

        return st.isEmpty() ? 0 : st.peek();
    }
}