class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        int l1 = s1.length();
        int l2 = s2.length();
        for (int i = 0; i < l1; i++) {
            map[s1.charAt(i)-'a']++;
        }
        int head = 0;
        int tail = 0;
        while (tail < l2) {
            map[s2.charAt(tail)-'a']--;
            if (tail-head+1 > l1) {
                map[s2.charAt(head++)-'a']++;
            }
            if (checkMap(map)) {
                return true;
            }
            tail++;
        }

        return false;
    }

    private boolean checkMap(int[] map) {
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }


}