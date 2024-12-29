class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> stCount = new Stack<>();
        Stack<StringBuilder> stStr = new Stack<>();
        
        StringBuilder res = new StringBuilder("");
        StringBuilder tmp;

        int n = s.length();
        int idx = 0;
        int val;
        
        while (idx < n) {
            if (Character.isDigit(s.charAt(idx))) {
                val = 0;
                while (idx < n && Character.isDigit(s.charAt(idx))) {
                    val = val * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                stCount.push(val);
                continue;
            } else if (s.charAt(idx) == '[') {
                stStr.push(res);
                res = new StringBuilder();
            } else if (s.charAt(idx) == ']') {
                tmp = stStr.pop();
                val = 0;
                while (val < stCount.peek()) {
                    tmp.append(res);
                    val++;
                }
                stCount.pop();
                res = tmp;
            } else {
                res.append(s.charAt(idx));
            }
            idx++;
        }
        return res.toString();    
    }
}