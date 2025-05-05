class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (isValidForInsert(s.charAt(i))) {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty() || !isValidCombination(st.peek(), s.charAt(i))) {
                    return false;
                } 
                st.pop();
            }
        }
        return st.isEmpty();
    }

    private boolean isValidForInsert(char a) {
        return a == '(' || a == '[' || a == '{';
    }

    private boolean isValidCombination(char a, char b) {
        return (a == '(' && b == ')')
                || (a == '{' && b == '}')
                || (a == '[' && b == ']');
    }
}