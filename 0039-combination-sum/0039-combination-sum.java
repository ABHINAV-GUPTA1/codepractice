class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        f(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    private void f(int idx, int[] arr, int target, List<Integer> tmp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (idx >= arr.length) {
            return;
        }
        f(idx+1, arr, target, tmp, res);
        if (target >= arr[idx]) {
            tmp.add(arr[idx]);
            f(idx, arr, target-arr[idx], tmp, res);
            tmp.remove(tmp.size()-1);
        }
    }
}