class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    q.offer(st.pop());
                }
                if (!st.isEmpty()) {
                    st.pop();
                }
                while (!q.isEmpty()) {
                    st.push(q.poll());
                }
            } else { // ( or a-z
                st.push(arr[i]);
            }
        }

        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }

        return sb.toString();
    }
}