class Solution {
    public boolean isIsomorphic(String s, String t) {
        int slength = s.length();
        int tlength = t.length();
        if (slength != tlength) {
            return false;
        }
        
        int[] sArr = new int[256];
        int[] tArr = new int[256];

        for (int idx = 0; idx < slength; idx++) {
            if (sArr[s.charAt(idx)] != tArr[t.charAt(idx)]) {
                return false;
            }
            sArr[s.charAt(idx)] = idx + 1;
            tArr[t.charAt(idx)] = idx + 1;
        }

        return true;
    }
}