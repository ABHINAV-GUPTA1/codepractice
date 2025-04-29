class Solution {
    
    private static final String EMPTY = "";
    
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs[0].length() == 0) {
            return EMPTY;
        }
        
        int len = strs[0].length();
        int arrLen = strs.length;

        for (int i = 1; i < arrLen; i++) {
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