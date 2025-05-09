class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res = new ArrayList<>();
        comb(arr, 0, n, k, new ArrayList<>(), res);
        return res;
    }

    private void comb(int[] arr, int idx, int target, int size, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() > size || target < 0) {
            return;
        }
        if (target == 0 && tmp.size() == size) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            // if (i > idx && arr[i] == arr[i - 1]) {
            //     continue;
            // }
            if (arr[i] > target) {
                return;
            }
            tmp.add(arr[i]);    
            comb(arr, i + 1, target - arr[i], size, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}