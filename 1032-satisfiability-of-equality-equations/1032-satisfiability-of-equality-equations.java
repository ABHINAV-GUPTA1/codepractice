class Solution {
    int[] parent;
    int[] rank;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (parent[fa] != parent[fb]) {
            if (rank[fa] >= rank[fb]) {
                parent[fb] = fa;
                rank[fa]++;
            } else {
                parent[fa] = fb;    
                rank[fb]++;
            }
        }
    }

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < equations.length; i++) {
            String s = equations[i];
            if (s.charAt(1) == '=') {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }
        for (int i = 0; i < equations.length; i++) {
            String s = equations[i];
            if (s.charAt(1) == '!' && find(s.charAt(0) - 'a') == find(s.charAt(3) - 'a')) {
                return false;
            }
        }

        return true;
    }
}