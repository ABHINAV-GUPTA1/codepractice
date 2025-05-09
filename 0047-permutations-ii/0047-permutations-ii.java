class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs (nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs (int[] arr, List<List<Integer>> res, List<Integer> tmp, boolean[] vis) {
        if (tmp.size() == arr.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (vis[i] || (i > 0 && arr[i] == arr[i - 1] && !vis[i-1])) {
                continue;
            }
            tmp.add(arr[i]);
            vis[i] = true;
            dfs(arr, res, tmp, vis);
            vis[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}