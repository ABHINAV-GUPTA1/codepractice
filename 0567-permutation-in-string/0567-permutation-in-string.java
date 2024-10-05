class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int i = 0, j = 0;
        int map[] = new int[26];
        for (; i < l1; i++) {
            map[s1.charAt(i)-'a']++;
        }
        i = 0;
        while (i < l2) {
            map[s2.charAt(i) - 'a']--;
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
        for (int i = 0; i <26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }

        return true;
    }
}