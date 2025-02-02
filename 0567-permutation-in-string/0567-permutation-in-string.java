class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        int k = 0;
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i)-'a']++;
            k += (s1.charAt(i)-'a');
        }
        int head = 0;
        int tail = 0;
        while (tail < s2.length()) {
            map[s2.charAt(tail)-'a']--;
            k -= (s2.charAt(tail)-'a');
            if (tail-head+1 > s1.length()) {
                map[s2.charAt(head++)-'a']++;
                k += (s2.charAt(head-1)-'a');
            }
            if (k == 0 && checkMap(map)) {
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