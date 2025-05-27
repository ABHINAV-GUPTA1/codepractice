class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetter(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetter(s.charAt(end))) {
                end--;
            }
            char c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;
            start++;
            end--;
        }

        return String.valueOf(arr);
    }
}