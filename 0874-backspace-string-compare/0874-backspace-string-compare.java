class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = getStr(s);
        Stack<Character> st2 = getStr(t);
        if (st1.size() != st2.size()) {
            return false;
        }
        while (!st1.isEmpty()) {
            if (st1.pop() != st2.pop()) {
                return false;
            }
        }
        return true;
    }

    private Stack<Character> getStr(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty() && s.charAt(i) != '#') {
                st.push(s.charAt(i));
            } else {
                if (s.charAt(i) == '#') {
                    if (!st.isEmpty()) {
                        st.pop();
                    }
                } else {
                    st.push(s.charAt(i));
                }
            }
        }
        return st;
    }
}