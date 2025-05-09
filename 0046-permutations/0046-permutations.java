class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(nums, vis, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] arr, boolean[] vis, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == arr.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                tmp.add(arr[i]);
                dfs(arr, vis, tmp, res);
                tmp.remove(tmp.size() - 1);
                vis[i] = false;
            }
        }
    }
}