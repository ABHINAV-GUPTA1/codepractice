class Solution {
    public boolean isAnagram(String s, String t) {
        
        int slength = s.length();
        int tlength = t.length();
        
        if (slength != tlength) {
            return false;
        }

        int[] sArr = new int[26];

        for (int i = 0; i < slength; i++) {
            sArr[s.charAt(i) - 'a']++;
            sArr[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (sArr[i] != 0) {
                return false;
            }
        }

        return true;
    }
}