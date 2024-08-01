class Solution {
    long MOD = 1000000007;
    public int minNonZeroProduct(int p) {
        long totalElements = (1l << p)-1;
        return (int)(((totalElements%MOD)*(pow(totalElements-1, (totalElements)/2))%MOD));
    }

    private long pow(long x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x%MOD;
        }
        long newVal = ((x % MOD) * (x % MOD)) % MOD;
        if (n%2 == 0) {
            return (pow(newVal, n/2)%MOD);
        }

        return ((x%MOD)*(pow(newVal, n/2)%MOD))%MOD;
    }
}