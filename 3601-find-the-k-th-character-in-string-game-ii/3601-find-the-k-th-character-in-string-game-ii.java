class Solution {
    public char kthCharacter(long k, int[] operations) {
        if (k == 1) {
            return 'a';
        }        
        long newK = 0;
        int operType = 0;
        long len = 1;
        for (int i = 0; i < operations.length; i++) {
            len *= 2;
            if (len >= k) {
                newK = k - len / 2;
                operType = operations[i];
                break;    
            }
        }

        char newChar = kthCharacter(newK, operations);
        if (operType == 0) {
            return newChar;
        }
        return newChar == 'z' ? 'a' : (char) (newChar + 1);
    }

}