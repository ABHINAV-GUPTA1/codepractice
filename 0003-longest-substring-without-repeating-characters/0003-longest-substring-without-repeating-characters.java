class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int tail = 0;
        int head = 0;
        int ans = 0;
        while (head < s.length()) {
            if (set.contains(s.charAt(head))) {
                set.remove(s.charAt(tail++));
            } else {
                set.add(s.charAt(head++));
                ans = Math.max(ans, head - tail);
            }
        }

        return ans;
    }
}