class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        int length = s.length();
        
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(' 
                || s.charAt(i) == '{' 
                || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty() 
                    || !(isValid(st.peek(), s.charAt(i)))) {
                    return false;
                } 
                st.pop();
            }
        }    
        
        return st.isEmpty();
    }

    private boolean isValid(char a, char b) {
        return (a == '(' && b == ')')
                || (a == '{' && b == '}')
                || (a == '[' && b == ']');
    }
}