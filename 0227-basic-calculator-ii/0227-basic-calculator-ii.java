class Solution {
    public int calculate(String s) {
        int num = 0;
        Stack<Integer> st = new Stack<>();
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            boolean isDigit = s.charAt(i) >='0' && s.charAt(i) <= '9';
            if (isDigit) {
                num = num * 10 + (s.charAt(i)-'0');
            }
            if ((!isDigit && s.charAt(i) != ' ') || i == s.length()-1) {
                if (sign == '+') {
                    st.push(num);
                } else if (sign == '-') {
                    st.push(-num);
                } else if (sign == '*') {
                    st.push(st.pop() * num);
                } else if (sign == '/') {
                    st.push(st.pop() / num);
                }
                num = 0;
                sign = s.charAt(i);
            }
        }
        int res = 0;
        for (int i : st) {
            res += i; 
        }  

        return res;
    }
}