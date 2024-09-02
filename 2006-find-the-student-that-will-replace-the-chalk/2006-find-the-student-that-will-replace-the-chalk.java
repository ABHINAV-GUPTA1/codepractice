class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        int n = chalk.length;
        while (true) {
            int chalkToBeUsed = chalk[i];
            if (chalkToBeUsed > k) {
                return i;
            }
            k -= chalkToBeUsed;
            i++;
            if (i == n) {
                i = 0;
            }
        }    
    }
}