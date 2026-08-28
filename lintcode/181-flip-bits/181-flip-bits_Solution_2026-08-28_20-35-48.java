public class Solution {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     */
    public int bitSwapRequired(int a, int b) {
        int count=0;
       for (int i=0; i<32; i++) {
           if((a>>i&1)!=(b>>i&1))
                count++;
       }
       return count;
    }
}