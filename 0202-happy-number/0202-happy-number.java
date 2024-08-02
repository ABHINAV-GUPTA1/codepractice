class Solution {
    public boolean isHappy(int n) {
        if (n <= 1) {
            return n == 1;
        }
        int slow = square(n);
        int fast = square(square(n));
        while (slow != fast) {
            slow = square(slow);
            fast = square(square(fast));
        }

        return slow == 1;
    }

    private int square(int n) {
        if (n == 1) {
            return 1;
        }
        int x = 0;
        int val = 0;
        while (n > 0) {
            x = n%10;
            val += (x*x);
            n /= 10;
        }
        return val;
    }
}