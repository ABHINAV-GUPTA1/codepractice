class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int len = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            len = Math.min(len, strs[i].length());
            for (int j = 0; j < len; j++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    len = j;
                    break;
                }
            }
        }

        return strs[0].substring(0, len);
    }
}