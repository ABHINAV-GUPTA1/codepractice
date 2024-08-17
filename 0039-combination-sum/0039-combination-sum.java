class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), candidates, target);
        return res;
    }

    private void backtrack(int idx, List<Integer> tmp, int[] arr, int target) {
        if (idx == arr.length) {
            if (target == 0) {
                res.add(new ArrayList<>(tmp));
                return;
            }
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        backtrack(idx+1, tmp, arr, target);

        if (target-arr[idx] >= 0) {
            tmp.add(arr[idx]);
            backtrack(idx, tmp, arr, target-arr[idx]);
            tmp.remove(tmp.size()-1);
        }
    }
}