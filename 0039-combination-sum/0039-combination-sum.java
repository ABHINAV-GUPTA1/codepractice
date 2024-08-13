class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<>());
        return res;
    }

    private void backtrack(int idx, int[] arr, int target, List<Integer> tmp) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (idx >= arr.length || target < 0) {
            return;
        }

        backtrack(idx+1, arr, target, tmp);

        if (target-arr[idx] >= 0) {
            tmp.add(arr[idx]);
            backtrack(idx, arr, target-arr[idx], tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}