class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2) {
            return false;
        }
        int map[] = new int[26];
        for (int i = 0; i < l1; i++) {
            map[s1.charAt(i)-'a']++;
        }

        int i = 0;
        int j = 0;
        while (i < l2) {
            map[s2.charAt(i)-'a']--;
            if (i-j+1 > l1) {
                map[s2.charAt(j++)-'a']++;
            }
            if (check(map)) {
                return true;
            }
            i++;
        }

        return false;
    }

    private boolean check(int[] map) {
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }

        return true;
    }
}