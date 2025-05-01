class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        
        int head = 0;
        int tail = 0;
        int length = s.length();
        int ans = 0;

        while (head < length) {
            if (set.add(s.charAt(head))) {
                ans = Math.max(ans, head - tail + 1);
                head++;
            } else {
                set.remove(s.charAt(tail++));
            }
        }

        return ans;
    }
}