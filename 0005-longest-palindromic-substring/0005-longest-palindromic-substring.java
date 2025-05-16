class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        int maxlen = 0; 
        int start = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // even palindrome
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if (left >= 0 && right < n && maxlen < right - left + 1) {
                maxlen = right - left + 1;
                start = left;
            }
            
            // odd palindrome
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if (left >= 0 && right < n && maxlen < right - left + 1) {
                maxlen = right - left + 1;
                start = left;
            }
        }
        return s.substring(start, start + maxlen);
    }
}