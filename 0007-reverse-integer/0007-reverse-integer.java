class Solution {
    public int reverse(int x) {
        // long res = 0;
        // while (x != 0) {
        //     res = res*10 + x%10;
        //     x = x/10;
        // }
        // if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
        //     return 0;
        // }

        // return (int)res;

        boolean sign = false;
        if (x < 0) {
            sign = true;
            x = -x;
        }
        int res = 0;
        int tmp;
        while (x > 0) {
            tmp = res *10 + x%10;
            if (tmp/10 != res) {
                return 0;
            }
            res = tmp;
            x = x/10;
        }

        return sign ? -res : res;
    }
}