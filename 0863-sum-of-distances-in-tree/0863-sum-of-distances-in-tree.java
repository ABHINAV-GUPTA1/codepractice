class Solution {
    Map<Integer, List<Integer>> map;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], x->new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], x->new ArrayList<>()).add(edges[i][0]);
        }
        int[] ans = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        postOrder(0, -1, count, ans);
        preOrder(0, -1, n, count, ans);
        return ans;
    }

    private void postOrder(int currNode, int parent, int[] count, int[] ans) {
        List<Integer> childList = map.get(currNode);
        if (childList == null) {
            return;
        }
        for (int child : childList) {
            if (child != parent) {
                postOrder(child, currNode, count, ans);

                count[currNode] += count[child];
                ans[currNode] += count[child] + ans[child];
            }
        }
    }

    private void preOrder(int currNode, int parent, int n, int[] count, int[] ans) {
        List<Integer> childList = map.get(currNode);
        if (childList == null) {
            return;
        }
        for (int child : childList) {
            if (child != parent) {
                ans[child] = ans[currNode] + (n - count[child]) - count[child];
                preOrder(child, currNode, n, count, ans);
            }
        }
    }
}