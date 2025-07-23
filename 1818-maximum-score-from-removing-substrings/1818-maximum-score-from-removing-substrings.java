class Solution {
    /**
        Method 2: using 2 pointers
     */
    public int maximumGain(String s, int x, int y) {
        String max;
        String min;
        if (x > y) {
            String tmpStr = findScoreOptimised(s, "ab");
            int ans = ((s.length() - tmpStr.length()) / 2) * x;

            String tmpStr2 = findScoreOptimised(tmpStr, "ba");
            ans += ((tmpStr.length() - tmpStr2.length()) / 2) * y;
            return ans;
        }
        String tmpStr = findScoreOptimised(s, "ba");
        int ans = ((s.length() - tmpStr.length()) / 2) * y;

        String tmpStr2 = findScoreOptimised(tmpStr, "ab");
        ans += ((tmpStr.length() - tmpStr2.length()) / 2) * x;
        return ans;
    }

    private String findScoreOptimised(String s, String pattern) {
        int i = 0;
        char[] arr = s.toCharArray();
        for (int j = 0; j < arr.length; j++) {
            arr[i] = arr[j];
            i++;
            if (i > 1 && arr[i-2] == pattern.charAt(0) && arr[i - 1] == pattern.charAt(1)) {
                i -= 2;
            }
        }

        return new String(arr).substring(0, i);

    }
    
    /**
        Method 1 : Using stack
     */
    public int maximumGain_method1(String s, int x, int y) {
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