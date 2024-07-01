class Solution {
    /**
    
        Method 1
    */
    public int characterReplacement1(String s, int k) {
        int head = 0;
        int tail = 0;
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int n = s.length();
        char c;
        int maxf = 0, cnt;
        while (tail < n) {
            c = s.charAt(tail);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxf = Math.max(map.get(c), maxf);
            while ((tail-head+1)-maxf > k) {
                c = s.charAt(head++);
                cnt = map.get(c);
                if (cnt == 1) {
                    map.remove(c);
                } else {
                    map.put(c, cnt-1);
                }
                maxf = 0;
                for (c = 'A'; c <= 'Z'; c++) {
                    maxf = Math.max(maxf, map.getOrDefault(c, 0));
                }
            }
            ans = Math.max(ans, tail - head + 1);
            tail++;
        }

        return ans;
    }

    public int characterReplacement(String s, int k) {
        int head = 0;
        int tail = 0;
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int n = s.length();
        char c;
        int maxf = 0, cnt;
        while (tail < n) {
            c = s.charAt(tail);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxf = Math.max(map.get(c), maxf);
            if ((tail-head+1)-maxf > k) {
                c = s.charAt(head++);
                cnt = map.get(c);
                if (cnt == 1) {
                    map.remove(c);
                } else {
                    map.put(c, cnt-1);
                }
            }
            ans = Math.max(ans, tail - head + 1);
            tail++;
        }

        return ans;
    }
}