class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    q.offer(st.pop());
                }
                if (!st.isEmpty()) {
                    st.pop();
                }
                while (!q.isEmpty()) {
                    st.push(q.poll());
                }
            } else {
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}