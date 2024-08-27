class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair<Integer, Double>>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], x-> new ArrayList<>()).add(new Pair<Integer, Double>(edges[i][1], succProb[i]));
            map.computeIfAbsent(edges[i][1], x-> new ArrayList<>()).add(new Pair<Integer, Double>(edges[i][0], succProb[i]));
        }
        double[] maxProb = new double[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start_node);
        maxProb[start_node] = 1d;
        while (!q.isEmpty()) {
            int currNode = q.poll();
            for (Pair<Integer, Double> neighbor : map.getOrDefault(currNode, new ArrayList<>())) {
                int nxtNode = neighbor.getKey();
                double nxtProb = neighbor.getValue();

                double prob = maxProb[currNode] * nxtProb;
                if (prob > maxProb[nxtNode]) {
                    maxProb[nxtNode] = prob;
                    q.offer(nxtNode);
                }
            }
        }

        return maxProb[end_node];
    }
}