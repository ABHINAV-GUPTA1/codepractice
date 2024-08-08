class Solution {
    public boolean validPalindrome(String s) {
        return isValid(s, 0, s.length()-1, 0);
    }

    boolean isValid(String s, int left, int right, int count) {
        if (left >= right) {
            return true;
        }
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (count >= 1) {
                    return false;
                }
                count++;
                return isValid(s, left+1, right, count) || isValid(s, left, right-1, count);
            }
            
            left++;
            right--;
        }

        return count <= 1;
    }
}