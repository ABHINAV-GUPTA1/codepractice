public class Solution {
    /**
     * @param num: An integer
     * @return: An integer, the number of ones in num
     */
    public int countOnes(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}