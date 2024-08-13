class Solution {
    List<List<Integer>> res;
    int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        res = new ArrayList<>();
        this.k = k;
        backtrack(0, arr, n, new ArrayList<>());
        return res;
    }

    void backtrack(int idx, int[] arr, int target, List<Integer> tmp) {
        if (target < 0 || tmp.size() > k) {
            return;
        }
        if (target == 0 && tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i-1] || target-arr[i] < 0) {
                continue;
            }
            tmp.add(arr[i]);
            backtrack(i+1, arr, target-arr[i], tmp);
            tmp.remove(tmp.size()-1);

        }
        
    }
}