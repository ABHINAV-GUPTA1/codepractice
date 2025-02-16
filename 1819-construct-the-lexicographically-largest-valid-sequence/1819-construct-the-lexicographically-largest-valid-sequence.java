class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2*n-1];
        boolean[] used = new boolean[n+1];    
        solve(0, res, n, used);
        return res;
    }

    private boolean solve(int i, int[] res, int n, boolean[] used) {
        if (i >= res.length) {
            return true;
        }
        if (res[i] != 0) {
            return solve(i+1, res, n, used);
        }
        for (int num = n; num >= 1; num--) {
            if (used[num]) {
                continue;
            }
            used[num] = true;
            res[i] = num;
            if (num == 1) {
                if (solve(i+1, res, n, used)) {
                    return true;
                }
            } else {
                int j = i + num;
                if (j < res.length && res[j] == 0) {
                    res[j] = num;
                    if (solve(i+1, res, n, used)) {
                        return true;
                    }
                    res[j] = 0;
                }
                
            }
            used[num] = false;
            res[i] = 0;
        }
        return false;
    }
}