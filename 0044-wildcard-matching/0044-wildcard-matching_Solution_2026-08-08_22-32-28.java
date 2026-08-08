class Solution {
    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean[] prev = new boolean[m + 1];
        boolean[] curr = new boolean[m + 1];

        // Base Case
        prev[0] = true;

        // Pattern vs Empty String
        for (int j = 1; j <= m; j++) {
            prev[j] = isAllStars(p, j);
        }

        for (int i = 1; i <= n; i++) {

            curr[0] = false;

            for (int j = 1; j <= m; j++) {

                // Current characters match or '?'
                if (s.charAt(i - 1) == p.charAt(j - 1) ||
                    p.charAt(j - 1) == '?') {

                    curr[j] = prev[j - 1];
                }

                // Current pattern character is '*'
                else if (p.charAt(j - 1) == '*') {

                    curr[j] = prev[j] || curr[j - 1];
                }

                else {
                    curr[j] = false;
                }
            }

            prev = curr.clone();
        }

        return prev[m];
    }

    private boolean isAllStars(String p, int len) {
        for (int i = 0; i < len; i++) {
            if (p.charAt(i) != '*')
                return false;
        }
        return true;
    }
}