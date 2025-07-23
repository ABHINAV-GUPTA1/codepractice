class Solution {
    /**
        Method 1 : Using stack
     */
    public int maximumGain(String s, int x, int y) {
        String max;
        String min;
        if (x > y) {
            String tmpStr = findScore(s, "ab");
            int ans = ((s.length() - tmpStr.length()) / 2) * x;

            String tmpStr2 = findScore(tmpStr, "ba");
            ans += ((tmpStr.length() - tmpStr2.length()) / 2) * y;
            return ans;
        }
        String tmpStr = findScore(s, "ba");
        int ans = ((s.length() - tmpStr.length()) / 2) * y;

        String tmpStr2 = findScore(tmpStr, "ab");
        ans += ((tmpStr.length() - tmpStr2.length()) / 2) * x;
        return ans;
    }

    private String findScore(String str, String pattern) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (!st.isEmpty() && st.peek() == pattern.charAt(0) && str.charAt(i) == pattern.charAt(1)) {
                st.pop();
            } else {
                st.push(str.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
        
    }
}