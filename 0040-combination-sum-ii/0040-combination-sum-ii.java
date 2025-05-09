class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, 0, target, new ArrayList<>(), res);
        return res;    
    }

    private void combinationSum2(int[] arr, int idx, int target, List<Integer> tmp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                return;
            }
            tmp.add(arr[i]);
            combinationSum2(arr, i + 1, target - arr[i], tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}