class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>());
        return res;
    }

    private void backtrack(int idx, int[] arr, int target, List<Integer> tmp) {
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

        for (int i = idx; i < arr.length; i++) {
            if ((i > idx && arr[i] == arr[i-1]) || (target-arr[i] < 0)) {
                continue;
            }
            tmp.add(arr[i]);
            backtrack(i+1, arr, target-arr[i], tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}