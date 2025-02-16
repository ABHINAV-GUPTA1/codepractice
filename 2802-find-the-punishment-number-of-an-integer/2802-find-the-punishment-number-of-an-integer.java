class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int val = i * i;
            if (check(0, 0, String.valueOf(val), i)) {
                ans += val;
            }  
        }
        return ans;
    }

    private boolean check(int i, int sum, String val, int reqSum) {
        if (val.length() < i) {
            return false;
        }
        if (i == val.length()) {
            return reqSum == sum;
        }
        if (sum > reqSum) {
            return false;
        }
        for (int j = i; j < val.length(); j++) {
            String curr = val.substring(i, j+1);
            int currVal = Integer.parseInt(curr);
            if (currVal+sum > reqSum) {
                return false;
            }
            if (check(j+1, sum+currVal, val, reqSum)) {
                return true;
            }
        }
        return false;
    }
}