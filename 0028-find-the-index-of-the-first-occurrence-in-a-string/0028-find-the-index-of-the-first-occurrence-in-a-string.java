class Solution {
    public int strStr(String haystack, String needle) {
        int lps[] = computeLPS(needle);
        int i = 0;
        int j = 0;
        int length = haystack.length();
        while (i < length) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j;
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        return -1;
    }

    private int[] computeLPS(String s) {
        int i = 1;
        int j = 0;
        int len = s.length();
        int[] lps = new int[len];
        lps[0] = 0;
        while (i < len) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i++] = ++j;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
        }

        return lps;
    }
}