class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i : banned) {
            set.add(i);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                if (maxSum - i >= 0) {
                    maxSum -= i;
                    ans++;
                } else {
                    break;
                }
            } 
        }

        return ans;
    }
}