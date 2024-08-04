class Solution {
    public double myPow(double x, int n) {
        return solve(x, n);    
    }

    double solve(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if ( n < 0) {
            return solve(1/x, -n);
        }
        double val = solve(x, n/2);
        if (n%2 == 0) {
            return val*val;
        }
        return x*val*val;
    }
}