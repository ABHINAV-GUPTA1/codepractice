class Solution {
    public String makeSmallestPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] arr = s.toCharArray();
        while (left < right) {
            char a = arr[left];
            char b = arr[right];
            if (a > b) {
                arr[left] = b;
            } else {
                arr[right] = a;
            }
            left++;
            right--;
        }
        return new String(arr);
    }
}