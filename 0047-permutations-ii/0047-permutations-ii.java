class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] arr, List<Integer> tmp, boolean[] vis) {
        if (tmp.size() == arr.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (vis[i] || (i > 0 && arr[i] == arr[i-1] && !vis[i-1])) {
                continue;
            }
            tmp.add(arr[i]);
            vis[i] = true;
            dfs(arr, tmp, vis);
            vis[i] = false;
            tmp.remove(tmp.size()-1);
            
        }
    }

}