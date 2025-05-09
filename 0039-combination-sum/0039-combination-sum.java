class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void combinationSum(int[] arr, int idx, int target, List<Integer> tmp, List<List<Integer>> res) {
        if (idx == arr.length) {
            if (target == 0) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        if (target >= arr[idx]) {
            tmp.add(arr[idx]);
            combinationSum(arr, idx, target - arr[idx], tmp, res);
            tmp.remove(tmp.size() - 1);
        }
        combinationSum(arr, idx + 1, target, tmp, res);
    }
}