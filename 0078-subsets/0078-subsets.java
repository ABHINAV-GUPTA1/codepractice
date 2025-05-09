class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs (int[] arr, int idx, List<Integer> tmp, List<List<Integer>> res) {
        res.add(new ArrayList<>(tmp));
        for (int i = idx; i < arr.length; i++) {
            tmp.add(arr[i]);
            dfs(arr, i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}