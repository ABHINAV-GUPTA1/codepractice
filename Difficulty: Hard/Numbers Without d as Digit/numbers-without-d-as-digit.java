class Solution {
    public int countWithout(int n, int d) {
        // code here
        if (n == 0) return 0;

        String s = String.valueOf(n);
        int len = s.length();

        long[] power = new long[len + 1];
        power[0] = 1;

        for (int i = 1; i <= len; i++) {
            power[i] = power[i - 1] * 9;
        }

        long ans = 0;

        for (int digits = 1; digits < len; digits++) {
            if (d == 0) {
                ans += 9 * power[digits - 1];
            } else {
                ans += 8 * power[digits - 1];
            }
        }

        for (int i = 0; i < len; i++) {
            int cur = s.charAt(i) - '0';
            int remaining = len - i - 1;

            int choices = 0;

            if (i == 0) {
                choices = cur - 1;

                if (d != 0 && d < cur) {
                    choices--;
                }
            } else {
                choices = cur;

                if (d < cur) {
                    choices--;
                }
            }

            ans += (long) choices * power[remaining];

            if (cur == d) {
                return (int) ans;
            }
        }

        return (int) (ans + 1);
    }
}