class Solution {
    double res;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String, Map<String, Double>> map = new HashMap<>();
        int idx = 0;
        for (List<String> eqs : equations) {
            String u = eqs.get(0);
            String v = eqs.get(1);
            double val = values[idx++];
            map.computeIfAbsent(u, x->new HashMap<>()).put(v, val);
            map.computeIfAbsent(v, x->new HashMap<>()).put(u, 1/val); 
        }
        idx = 0;
        for (List<String> qrs : queries) {
            String u = qrs.get(0);
            String v = qrs.get(1);
            res = -1.0;
            if (map.containsKey(u) && map.containsKey(v)) {
                dfs(u, v, map, new HashSet<>(), 1.0);
            } 
            ans[idx++] = res;
        }

        return ans;
    }

    private void dfs (String u, String v, Map<String, Map<String, Double>> map, Set<String> vis, double prod) {
        if (vis.contains(u) || !map.containsKey(u)) {
            return;
        }
        vis.add(u);
        if (u.equals(v)) {
            res = prod;
            return;
        }
        for (Map.Entry<String, Double> me : map.get(u).entrySet()) {
            dfs(me.getKey(), v, map, vis, prod*me.getValue());
        }
        vis.remove(u);
    }
}