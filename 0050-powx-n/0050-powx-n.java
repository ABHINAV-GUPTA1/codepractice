class Solution {
    public double myPow(double x, int n) {
        return solve(x, (long)n);
    }

    private double solve(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return solve(1/x, -n);
        }
        double res = solve(x, n/2);
        if ((n&1) == 0) {
            return res*res;
        }
        return x*res*res;
    }
}