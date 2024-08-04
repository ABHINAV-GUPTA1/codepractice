class Solution {

    private boolean isSimilar(String s1, String s2) {
        int ans = 0;
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ans++;
            }
            if (ans > 2) {
                break;
            }
        }
        return ans == 0 || ans == 2;
    }
    public int numSimilarGroups(String[] strs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            for (int j = i+1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    adj.computeIfAbsent(i, x->new ArrayList<>()).add(j);
                    adj.computeIfAbsent(j, x->new ArrayList<>()).add(i);
                }
            }
        }
        int ans = 0;
        boolean[] vis = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                ans++;
            }
        }
        System.out.println(adj);
        return ans;
    }

    private void dfs(int i, Map<Integer, List<Integer>> map, boolean[] vis) {
        if (i == vis.length || i < 0 || vis[i] || map.get(i) == null) {
            return;
        }
        vis[i] = true;
        for (int v : map.get(i)) {
            if (!vis[v]) {
                dfs(v, map, vis);
            }
        }
    }
}