class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();
        if (s1len > s2len) {
            return false;
        }
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < s1len; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }     
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += map1[i] == map2[i] ? 1 : 0;
        }
        int head = 0, tail = s1len;
        while (tail < s2len) {
            if (count == 26) {
                return true;
            }
            int idx = s2.charAt(tail) - 'a';
            map2[idx]++;
            if (map2[idx] == map1[idx]) {
                count++;
            } else if (map2[idx] - 1 == map1[idx]){
                count--;
            }
            tail++;

            idx = s2.charAt(head) - 'a';
            map2[idx]--;
            if (map2[idx] == map1[idx]) {
                count++;
            } else if (map2[idx] + 1 == map1[idx]) {
                count--;
            }
            head++;
        }
        return count == 26;
    }
}