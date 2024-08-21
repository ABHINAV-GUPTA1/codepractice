class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int n = s.length();
        int maxlen = 1;
        int start = 0;
        for (int i = 0; i < n-1; i++) {
            left = i;
            int right = i+1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if ( (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) && right-left+1 > maxlen) {
                maxlen = right-left+1;
                start = left;
            }

            left= i - 1;
            right = i + 1;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if ( (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) && right-left+1 > maxlen) {
                maxlen = right-left+1;
                start = left;
            }
        }

        return s.substring(start, start+maxlen);
    }
}