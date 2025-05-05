class Solution {
    public String minWindow(String s, String t) {
        int[] map1 = new int[256];
        for (int i = 0; i < t.length(); i++) {
            map1[t.charAt(i)]++;
        }
        int l = 0, r = 0;
        int len = s.length();
        int count = 0;
        int minlen = Integer.MAX_VALUE, startIdx = -1;
        while (r < len) {
            map1[s.charAt(r)]--;
            if (map1[s.charAt(r)] >= 0) {
                count++;
            }
            while (count == t.length()) {
                if ((r - l + 1) < minlen) {
                    minlen = Math.min(minlen, r - l + 1);
                    startIdx = l;
                }
                map1[s.charAt(l)]++;
                if (map1[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }

        return (minlen == Integer.MAX_VALUE) ? "" : s.substring(startIdx, startIdx + minlen); 
    }
}