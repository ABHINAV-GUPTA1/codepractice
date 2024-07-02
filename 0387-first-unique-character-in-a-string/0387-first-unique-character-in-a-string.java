class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        int n = s.length();
        int idx;
        for (int i = 0; i < n; i++) {
            idx = s.charAt(i)-'a';
            map[idx]++;
        }
        for (int i = 0; i < n; i++) {
            idx = s.charAt(i)-'a';
            if (map[idx] == 1) {
                return i;
            }
        }

        return -1;
    }
}