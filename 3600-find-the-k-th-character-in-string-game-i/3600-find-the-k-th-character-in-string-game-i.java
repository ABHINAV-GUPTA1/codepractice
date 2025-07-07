class Solution {
    public char kthCharacter(int k) {
        if (k == 1) {
            return 'a';
        }
        int nk = 0;
        int len = 1;
        for (int i = 0; i < k; i++) {
            len *= 2;
            if (len >= k) {
                nk = k - len / 2;
                break;
            }
        }

        char c = kthCharacter(nk);
        return c == 'z' ? 'a' : (char) (c + 1);
    }
}