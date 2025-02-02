class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int j = 0;
        int i = 0;
        int n = s.length();
        while (i < n) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                max = Math.max(max, i-j+1);
                set.add(s.charAt(i++));
            }
        }
        return max;
    }
}