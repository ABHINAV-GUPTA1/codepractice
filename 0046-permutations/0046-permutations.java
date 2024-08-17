class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backtrack(nums, vis, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] arr, boolean[] vis, List<Integer> tmp) {
        
        if (tmp.size() == arr.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (vis[i]) {
                continue;
            }
            tmp.add(arr[i]);
            vis[i] = true;
            backtrack(arr, vis, tmp);
            vis[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}