class Solution {
    public String decodeString(String s) {
        Stack<Integer> stCount = new Stack<>();
        Stack<StringBuilder> stStr = new Stack<>();
        int idx = 0;
        int n = s.length();
        StringBuilder res = new StringBuilder();
        while (idx < n) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (idx < n && Character.isDigit(s.charAt(idx))) {
                    count = count*10 + (s.charAt(idx) - '0');
                    idx++;
                }
                stCount.push(count);
            } else if (s.charAt(idx) == '[') {
                stStr.push(res);
                res = new StringBuilder();
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder tmp = stStr.pop();
                int count = stCount.pop();
                for (int i = 0; i < count; i++) {
                    tmp.append(res);
                }
                res = tmp;
                idx++;
            } else {
                res.append(s.charAt(idx++));
            }
        }
        return res.toString();
    }
}