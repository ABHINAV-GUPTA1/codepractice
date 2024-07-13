class Solution {
    public String minWindow(String s, String t) {
        int start = -1;
        int minLen = Integer.MAX_VALUE;
        int tn = t.length();
        int sn = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int curr;
        for (int i = 0; i < tn; i++) {
            curr = map.getOrDefault(t.charAt(i), 0)+1;
            map.put(t.charAt(i), curr);
        }
        int cnt = 0;
        int left = 0;
        int right = 0;
        
        while (right < sn) {
            curr = map.getOrDefault(s.charAt(right), 0) - 1;
            map.put(s.charAt(right), curr);
            if (curr >= 0) {
                cnt++;
            }
            while (cnt == tn) {
                if (right - left + 1 < minLen) {
                    minLen = right-left+1;
                    start = left;
                }
                curr = map.getOrDefault(s.charAt(left), 0)+1;
                map.put(s.charAt(left++), curr);
                if (curr > 0) {
                    cnt--;
                }
            }
            right++;
        }

        return start == -1 ? "" : s.substring(start, start+minLen);
    }
}