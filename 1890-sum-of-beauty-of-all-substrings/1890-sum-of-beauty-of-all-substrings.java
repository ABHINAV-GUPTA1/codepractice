class Solution {
    public int beautySum(String s) {
        int res = 0;
        int[] map;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map = new int[26];
            for (int j = i; j < n; j++) {
                map[s.charAt(j)-'a']++;
                res += calculateBeauty(map);
            }
        }

        return res;
    }

    private int calculateBeauty(int[] map) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, map[i]);
            if (map[i] > 0) {
                min = Math.min(min, map[i]);
            }
        }

        return max-min;
    }
}