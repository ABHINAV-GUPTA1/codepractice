class Solution {
    public String reorganizeString(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        char letter = ' ';
        int letterCount = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] > letterCount) {
                letterCount = map[i];
                letter = (char) (i + 'a'); 
            }
        }
        if (letterCount > (s.length() + 1) / 2) {
            return "";
        }
        int idx = 0;
        char[] res = new char[s.length()];
        while (map[letter - 'a'] != 0) {
            res[idx] = letter;
            idx += 2;
            map[letter - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            while (map[i] != 0) {
                if (idx >= s.length()) {
                    idx = 1;
                }
                res[idx] =  (char) (i + 'a');
                idx += 2;
                map[i]--;
            }
        }

        return String.valueOf(res);
    }
}