class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int length = s.length();
        int maxLen = 0;
        int maxFreq = 0;
        int[] hash = new int[26];
        while (right < length) {
            hash[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);
            if ((right - left + 1) - maxFreq > k) {
                hash[s.charAt(left++) - 'A']--;
            }
            if ((right-left+1) - maxFreq <= k) {
                maxLen = Math.max(right - left + 1, maxLen);
            }
            right++;
        }
        return maxLen;
    }
}