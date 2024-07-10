class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for (String s : logs) {
            
            if (s.charAt(0) == '.' && s.charAt(1)=='.') {
                if (ans > 0)
                    ans -= 1;
            } else if (s.charAt(0) == '.') {
                continue;
            } else {
                ans += 1;
            }
        }

        return ans < 0 ? 0 : ans;
    }
}