class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            char c = token.charAt(token.length()-1);
            if (Character.isDigit(c)) {
                st.push(Integer.parseInt(token));
            } else {
                int b = st.pop();
                int a = st.pop();
                if (c == '+') {
                    st.push(a + b);
                } else if (c == '-') {
                    st.push(a - b);
                } else if (c == '*') {
                    st.push((int) ((long) a * b));
                } else {
                    st.push(a/b);
                }
            }
        }

        return st.pop();
    }
}