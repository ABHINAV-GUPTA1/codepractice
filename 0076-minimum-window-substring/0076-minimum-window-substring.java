class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int sn = s.length();
        int tn = t.length();
        for (int i = 0; i < tn; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int val = 0;
        int head = 0, tail = 0;
        int start = -1;
        int minLen = sn + 1;
        while (tail < sn) {
            int cnt = map.getOrDefault(s.charAt(tail), 0) - 1;
            map.put(s.charAt(tail), cnt);
            if (cnt >= 0) {
                val++;
            }
            while (val == tn) {
                if (tail-head+1 < minLen) {
                    minLen = tail-head+1;
                    start = head;
                }
                cnt = map.get(s.charAt(head)) + 1;
                if (cnt > 0) {
                    val--;
                }
                map.put(s.charAt(head++), cnt);
            }
            tail++;
        }
        return start == -1 ? "" : s.substring(start, start+minLen);
    }
}