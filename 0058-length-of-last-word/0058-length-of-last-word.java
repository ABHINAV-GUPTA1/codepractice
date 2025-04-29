class Solution {
    public int lengthOfLastWord(String s) {
        
        int currLen = 0;
        int length = s.length();

        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                currLen++;
            } else if (currLen != 0) {
                return currLen;
            }
        }
        
        return currLen;
    }
}