class Solution {
    char val = (char)255;
    public char nextGreatestLetter(char[] letters, char target) {
        char res = val;
        for (char c : letters) {
            if (c > target && res > c) {
                res = c;
            }
        }
        return res == val ? letters[0] : res;
    }
}