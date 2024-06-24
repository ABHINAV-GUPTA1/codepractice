class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            while (left < right && !isValid(s.charAt(left))) {
                left++;
            }
            while (right > left && !isValid(s.charAt(right))) {
                right--;
            }
            if (left >= right) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isValid(char c) {
        return (Character.isLetter(c) || Character.isDigit(c) );
    }

    private boolean isPalindrome(int i, int j, String s) {
        if (i >= j) {
            return true;
        }

        if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
            return isPalindrome(i+1, j-1, s);
        }

        if (!(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)) )) {
            return isPalindrome(i+1, j, s);
        }

        if (!(Character.isLetter(s.charAt(j)) || Character.isDigit(s.charAt(j)) )) {
            return isPalindrome(i, j-1, s);
        }

        return false;
    }

}