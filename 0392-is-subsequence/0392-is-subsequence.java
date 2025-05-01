class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int idx1 = 0, idx2 = 0;
        
        int slength = s.length();
        int tlength = t.length();
        
        while (idx1 < slength && idx2 < tlength) {
            if (s.charAt(idx1) == t.charAt(idx2)) {
                idx1++;
            }
            idx2++;
        }

        return idx1 == slength;
    }
}