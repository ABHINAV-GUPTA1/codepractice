class Solution {
    public int smallestNumber(int n, int t) {
        while (!isPossible(n, t)) {
            n++;
        }

        return n;
    }

    private boolean isPossible(int n, int t) {
        int prod = 1;
        while (n > 0) {
            prod *= (n % 10);
            if (prod == 0) {
                break;
            }
            n /= 10;
        }
        return (prod % t) == 0;
    }
}