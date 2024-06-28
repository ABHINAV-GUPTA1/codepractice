class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = computeLPS(needle); // create LPS longest prefix suffix 
        int i = 0;
        int j = 0;
        int n = haystack.length();
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i-j;
                }
            } else {
                if (j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    int[] computeLPS(String s) {
        int i = 1;
        int j = 0;
        int[] lps = new int[s.length()];
        lps[0] = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i++] = ++j;
            } else {
                if (j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        return lps;
    }
}